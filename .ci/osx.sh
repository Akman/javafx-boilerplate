#!/bin/bash

tar xzfp $JPACKAGE_ARCHIVE_NAME

# chmod +x .ci/osx-add-key.sh
# sh .ci/osx-add-key.sh

# if [ -n "${TRAVIS_TAG}" -a "${TRAVIS_OS_NAME}" = "osx" ]; then
#   openssl aes-256-cbc -k "$ENC_SECRET" -in app/assets/osx/codesign.cer.enc -out app/assets/osx/codesign.cer -d;
#   openssl aes-256-cbc -k "$ENC_SECRET" -in app/assets/osx/codesign.p12.enc -out app/assets/osx/codesign.p12 -d;
# fi
