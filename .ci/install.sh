#!/bin/bash

# .ci/install.sh

set -ev

if [ -f .travis.env ]; then
  rm -rf .travis.env
fi
touch .travis.env

if [ -n "${TRAVIS_TAG}" ]; then
  echo "export VERSION=${TRAVIS_TAG}" >> .travis.env
fi

if [ -f .ci/${TRAVIS_OS_NAME}/install.sh ]; then
  .ci/${TRAVIS_OS_NAME}/install.sh
fi
