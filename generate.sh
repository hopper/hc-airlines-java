#!/usr/bin/env bash
set -euo pipefail

# Regenerate the Java SDK from the live Airline API OpenAPI spec.
#
# Generation is intentionally scoped to apis + models (`--global-property apis,models`).
# Supporting files (ApiClient.java, JSON.java, build.gradle, README.md, ...) are NOT
# regenerated because they carry hand-maintained customizations. After changing the
# spec you may still need to manually update some of them — see REGENERATING.md.

docker run --rm -v "${PWD}:/local" openapitools/openapi-generator-cli:v7.10.0 generate \
    -i https://airlines-api.hopper.com/airline/v1.1/docs/docs.yaml \
    -g java \
    -o /local \
    --config /local/config.json \
    --skip-validate-spec \
    --package-name com.hopper.cloud.airlines \
    --global-property apis,models,apiTests=false,modelTests=false

# Strip the generator's client-side JSON validation (validateJsonElement /
# openapiRequiredFields) so the client tolerates unknown/extra fields returned by a
# newer version of the API (forward-compatibility). This codifies the manual removal
# from commit c2061d4. Requires python3. See REGENERATING.md.
python3 scripts/strip_validation.py
