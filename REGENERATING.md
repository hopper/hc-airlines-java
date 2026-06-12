# Regenerating the SDK

This SDK is **generated** from the Airline API's OpenAPI spec by [OpenAPI Generator]
(7.10.0), with a **hand-maintained layer** on top. Regeneration is not a clean
one-button operation — read this before you regenerate.

## How to regenerate

```bash
./generate.sh
```

This:
1. Pulls the **live** spec from `https://airlines-api.hopper.com/airline/v1.1/docs/docs.yaml`
   (NOT the committed `api/openapi.yaml`, which is only a snapshot). Your API changes
   must be **deployed** for them to appear — or temporarily point `-i` at a local spec.
2. Runs OpenAPI Generator scoped to **apis + models only**
   (`--global-property apis,models`). Supporting files are intentionally NOT
   regenerated (see below).
3. Runs `scripts/strip_validation.py` to remove the generator's client-side JSON
   validation (see "Why validation is stripped").

Requires Docker and python3.

## Why generation is scoped to apis + models

Scoping protects the hand-customized **supporting files** the generator would
otherwise overwrite:

- `ApiClient.java` — custom OAuth retry headers, custom `authUrl`/`audience`.
- `build.gradle` — the version and `incrementXVersion` tasks, dependency pins.
- `README.md`, `pom.xml`, etc.

The trade-off: supporting files are **not** auto-updated, so some need manual care
after a spec change — see the checklist below.

## Why validation is stripped

The generator emits `validateJsonElement` + `openapiRequiredFields` on every model
and calls them on deserialization. They throw on any field not present in the SDK's
copy of the schema, which makes each client release **brittle** against a newer API
that returns extra fields. We deliberately remove them (originally by hand in commit
`c2061d4`; now codified in `scripts/strip_validation.py`) so the client tolerates
unknown/extra fields. `strip_validation.py` is idempotent and reproduces that removal
exactly (including the qualified `<Subtype>.validateJsonElement(...)` calls inside
oneOf unions).

> Alternative under discussion: setting `disallowAdditionalPropertiesIfNotPresent=false`
> in `config.json` keeps required/type checks but drops only the brittle
> additional-properties check. We currently strip all of it to match historical behavior.

## Supporting-file re-apply checklist (after regenerating)

The scoped generation leaves these to you:

1. **`JSON.java` — discriminator registry.** New `oneOf` unions must be registered
   here or they won't (de)serialize. For each new union add (a) a
   `registerTypeSelector(...)` block mapping each subtype's discriminator value, and
   (b) a `gsonBuilder.registerTypeAdapterFactory(new <Model>.CustomTypeAdapterFactory())`
   for the union and each member. Pattern: see the existing `Channel` / `FormOfPayment`
   / `Browser` blocks. Tip: run a one-off **full** regen into a throwaway dir
   (drop `--global-property apis,models`) and copy the new lines from its `JSON.java`.
2. **`ApiClient.java`** — confirm the OAuth/header/authUrl customizations are intact
   (scoped generation should leave it untouched; verify with `git diff`).
3. **Version** — bump `build.gradle` `version` and `config.json` `artifactVersion`.
4. **Examples / `HopperClient`** — generated method signatures can change (e.g. making
   a parameter optional reorders it; field types can change). Fix any breakage; the
   compile gate (`./gradlew compileJava`) catches it.
5. **Orphans** — the generator only writes, never deletes. Models for endpoints removed
   from the spec linger as dead files. Remove them deliberately (with dependency
   analysis) — do not bulk-delete, as supporting files (e.g. `AbstractOpenApiSchema`)
   and hand-maintained helper models live in the same package.

## Verify

```bash
./gradlew compileJava   # compiles main + examples
./gradlew test          # runs HopperClientTest + serialization smoke test
```
