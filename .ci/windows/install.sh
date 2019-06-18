#!/bin/bash

# .ci/windows/install.sh

set -ev

JPACKAGE_JDK_BASE_URL=https://download.java.net/java/early_access/jpackage/49
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-13-jpackage+49_windows-x64_bin.zip
JPACKAGE_JDK_HOME=jdk-13

wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
7z x -bd $JPACKAGE_JDK_ARCHIVE_NAME
echo "export BADASS_JLINK_JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

choco install adoptopenjdk --version 11.0.2.9
echo 'export JAVA_HOME="/c/Program Files/AdoptOpenJDK/jdk-11.0.2+9"' >> .travis.env
echo 'export PATH="/c/Program Files/AdoptOpenJDK/jdk-11.0.2+9/bin":$PATH' >> .travis.env

# choco install wixtoolset
# choco install innosetup




