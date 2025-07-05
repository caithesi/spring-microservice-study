**study spring microservice base on the book spring micro service in action, 2nd edittion

i created build script for either docker or podman

in case run with podman, make sure 

go to
/etc/containers/registries.conf

unqualified-search-registries = ["docker.io"]

to use the same docker file


or can config to run temporary

## example for vault podman

podman run -d -p 8200:8200 --name vault -e 'VAULT_DEV_ROOT_TOKEN_ID=myroot' -e 'VAULT_DEV_LISTEN_ADDRESS=0.0.0.0:8200' hashicorp/vault

http://0.0.0.0:8200/ui/vault/auth**