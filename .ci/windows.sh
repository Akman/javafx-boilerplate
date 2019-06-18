#!/bin/bash

7z x -bd $JPACKAGE_ARCHIVE_NAME

choco install adoptopenjdk --version 11.0.2.9

export JAVA_HOME="/c/Program Files/AdoptOpenJDK/jdk-11.0.2+9"
export PATH="/c/Program Files/AdoptOpenJDK/jdk-11.0.2+9/bin":$PATH

. $PROFILE

refreshenv
