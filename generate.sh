docker run --rm -v "${PWD}:/local" openapitools/openapi-generator-cli:v7.10.0 generate \
    -i https://airlines-api.hopper.com/airline/v1.1/docs/docs.yaml \
    -g java \
    -o /local \
    --config /local/config.json \
    --skip-validate-spec \
    --package-name com.hopper.cloud.airlines \
    --global-property apis,models,apiTests=false,modelTests=false \
