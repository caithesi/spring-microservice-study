#!/bin/bash

SRC_DIR=$(pwd)/quadlets
TARGET_DIR=$HOME/.config/containers/systemd

mkdir -p "$TARGET_DIR"

for file in "$SRC_DIR"/*.{container,network}; do
    ln -sf "$file" "$TARGET_DIR/$(basename "$file")"
done

systemctl --user daemon-reload
