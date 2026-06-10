#!/usr/bin/env python3
"""
Strip generated client-side JSON validation from OpenAPI-generated model classes.

WHY
---
This SDK deliberately runs WITHOUT the generator's `validateJsonElement` checks so
the client tolerates unknown / extra fields returned by a newer version of the API
(forward-compatibility). Without this, the generated models throw on any field that
isn't in the SDK's copy of the schema, which makes every client release brittle
against an evolving server.

This was originally done by hand in commit c2061d4 ("removed validation checks",
2025-04-02). The repo regenerates from the live spec, which re-adds the checks every
time, so this script codifies the removal as part of `generate.sh`. See REGENERATING.md.

WHAT IT REMOVES (per model, matching c2061d4 exactly)
-----------------------------------------------------
  1. the `// a set of required properties/fields (JSON key names)` comment and the
     `openapiRequiredFields` initialization block inside the static initializer
     (the `private/public static HashSet<String> openapiRequiredFields;` *declaration*
     is left in place, as in c2061d4);
  2. the `public static void validateJsonElement(...)` method (both the large object
     variant — including its javadoc — and the 3-line enum variant), matched by braces;
  3. the `validateJsonElement(jsonElement);` call inside `CustomTypeAdapterFactory.read`.

Idempotent: running it again on already-stripped files is a no-op.

USAGE
-----
    python3 scripts/strip_validation.py [MODEL_DIR ...]

Defaults to `src/main/java/com/hopper/cloud/airlines/model` when no dir is given.
"""
import sys
import pathlib

DEFAULT_DIR = "src/main/java/com/hopper/cloud/airlines/model"

METHOD_SIG = "public static void validateJsonElement("
CALL_LINE = "validateJsonElement(jsonElement);"
REQUIRED_COMMENT = "// a set of required properties/fields (JSON key names)"


def _skip_braced_block(lines, i):
    """Return the index just past the closing brace of the block whose first '{'
    is on (or after) line i. Brace-counts; ignores that generated validation code
    contains no '{'/'}' inside string literals."""
    depth = 0
    started = False
    while i < len(lines):
        for ch in lines[i]:
            if ch == "{":
                depth += 1
                started = True
            elif ch == "}":
                depth -= 1
        i += 1
        if started and depth == 0:
            break
    return i


def _drop_preceding_javadoc_and_blanks(out):
    """Remove trailing blank lines from `out`, and a javadoc block (/** ... */)
    immediately above (with the blank lines that separated it)."""
    while out and out[-1].strip() == "":
        out.pop()
    if out and out[-1].strip() == "*/":
        while out and not out[-1].strip().startswith("/**"):
            out.pop()
        if out:
            out.pop()  # the '/**' line
        while out and out[-1].strip() == "":
            out.pop()


def strip_text(text):
    lines = text.splitlines()
    out = []
    i = 0
    n = len(lines)
    while i < n:
        stripped = lines[i].strip()

        # 2) validateJsonElement method (+ its javadoc) — brace-matched.
        if stripped.startswith(METHOD_SIG):
            _drop_preceding_javadoc_and_blanks(out)
            i = _skip_braced_block(lines, i)
            continue

        # 1a) the required-fields comment (drop it + the blank line above it).
        if stripped == REQUIRED_COMMENT:
            if out and out[-1].strip() == "":
                out.pop()
            i += 1
            continue

        # 1b) openapiRequiredFields init + .add(...) lines (NOT the declaration).
        if stripped.startswith("openapiRequiredFields"):
            i += 1
            continue

        # 3) validation call sites:
        #    - object models: `validateJsonElement(jsonElement);`
        #    - oneOf unions:  `<Subtype>.validateJsonElement(jsonElement);` (with its
        #      "// validate the JSON object ..." comment) inside the try/catch matcher.
        if stripped == "// validate the JSON object to see if any exception is thrown":
            i += 1
            continue
        if stripped.endswith(CALL_LINE):
            i += 1
            continue

        out.append(lines[i])
        i += 1

    result = "\n".join(out)
    if text.endswith("\n"):
        result += "\n"
    return result


def main(argv):
    dirs = argv[1:] or [DEFAULT_DIR]
    changed = 0
    scanned = 0
    for d in dirs:
        for path in sorted(pathlib.Path(d).rglob("*.java")):
            scanned += 1
            original = path.read_text()
            stripped = strip_text(original)
            if stripped != original:
                path.write_text(stripped)
                changed += 1
                print(f"  stripped: {path}")
    print(f"strip_validation: {changed} of {scanned} files modified")
    return 0


if __name__ == "__main__":
    sys.exit(main(sys.argv))
