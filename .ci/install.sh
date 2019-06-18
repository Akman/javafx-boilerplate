#!/bin/bash

# .ci/install.sh

set -ev

echo 'export GRADLE_OPTS=-Dfile.encoding=utf-8' > .travis.env

if [ -f .ci/${TRAVIS_OS_NAME}/install.sh ]; then
  .ci/${TRAVIS_OS_NAME}/install.sh
fi
