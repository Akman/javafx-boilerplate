#!/bin/bash

# Check if tag is present and run bundle script
#if [ -n "${TRAVIS_TAG}" ]; then
  export VERSION=${TRAVIS_TAG}
  chmod +x .ci/${TRAVIS_OS_NAME}.sh
  sh .ci/${TRAVIS_OS_NAME}.sh
#fi
