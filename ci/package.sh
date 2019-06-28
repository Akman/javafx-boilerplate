#!/bin/bash

# ci/package.sh

set -ev

if [ -n "${TRAVIS_TAG}" ]; then
  if [ -f ci/${TRAVIS_OS_NAME}/package.sh ]; then
    ci/${TRAVIS_OS_NAME}/package.sh
  fi
fi
