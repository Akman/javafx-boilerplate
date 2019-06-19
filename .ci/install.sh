#!/bin/bash

# .ci/install.sh

set -ev

echo 'export GRADLE_OPTS=-Dfile.encoding=utf-8' > .travis.env

if [ -n "${TRAVIS_TAG}" ]; then
  echo "export VERSION=${TRAVIS_TAG}" >> .travis.env
fi

if [ -f .ci/${TRAVIS_OS_NAME}/install.sh ]; then
  .ci/${TRAVIS_OS_NAME}/install.sh
fi
