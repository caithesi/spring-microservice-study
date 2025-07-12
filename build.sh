#!/bin/bash

# Exit immediately if any command fails
set -e

# Array of directories to process
directories=(
    "licensing-service"
    "configserver"
    "eurekaserver"
)

# Function to build in a directory
build_in_dir() {
    echo "start build procress for $1"
    pushd "$(dirname "$0")/$1/" > /dev/null
    ./build_podman.sh
    popd > /dev/null
    echo "finish build procress for $1"
    echo "--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++--\\++"
}

# Build in each directory
for dir in "${directories[@]}"; do
    build_in_dir "$dir"
done