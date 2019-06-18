#!/bin/bash

choco install adoptopenjdk --version 11.0.2.9
export PATH="/c/Program Files/AdoptOpenJDK/jdk-11.0.2+9/bin":$PATH
java --version
