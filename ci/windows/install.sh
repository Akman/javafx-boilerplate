#!/bin/bash

# ci/windows/install.sh

set -ev

# https://jdk.java.net/archive
JPACKAGE_JDK_BASE_URL=https://download.java.net/java/GA/jdk14.0.2/205943a0976c4ed48cb16f1043c5c647/12/GPL
JPACKAGE_JDK_ARCHIVE_NAME=openjdk-14.0.2_windows-x64_bin.zip
JPACKAGE_JDK_HOME=jdk-14
wget -q $JPACKAGE_JDK_BASE_URL/$JPACKAGE_JDK_ARCHIVE_NAME
7z x -bd $JPACKAGE_JDK_ARCHIVE_NAME
echo "export JPACKAGE_HOME=$(pwd)/$JPACKAGE_JDK_HOME" >> .travis.env

# FeatureMain	Core AdoptOpenJDK installation (DEFAULT)
# FeatureEnvironment	Update the PATH environment variable (DEFAULT)
# FeatureJarFileRunWith	Associate .jar files with Java applications (DEFAULT)
# FeatureJavaHome	Update the JAVA_HOME environment variable
# FeatureIcedTeaWeb	Install IcedTea-Web
# FeatureJNLPFileRunWith	Associate .jnlp files with IcedTea-web
# FeatureOracleJavaSoft	Updates registry keys HKLM/SOFTWARE/JavaSoft/
choco install adoptopenjdk --version 16.0.1.9 -y -ia ADDLOCAL=FeatureMain,FeatureEnvironment,FeatureJavaHome
echo 'export JAVA_HOME="/c/Program Files/AdoptOpenJDK/jdk-16.0.1.9-hotspot"' >> .travis.env

# choco install wixtoolset -y
wget -q https://github.com/wixtoolset/wix3/releases/download/wix3112rtm/wix311-binaries.zip
7z x -bd -owixtoolset wix311-binaries.zip
echo 'export WIX=$(pwd)/wixtoolset' >> .travis.env

echo 'export PATH="$JAVA_HOME/bin":"$WIX":$PATH' >> .travis.env

# special for Windows
echo 'export GRADLE_OPTS="-Dorg.gradle.daemon=false"' >> .travis.env
