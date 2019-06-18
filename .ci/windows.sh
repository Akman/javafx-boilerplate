#!/bin/bash

7z x -bd $JPACKAGE_ARCHIVE_NAME

choco install adoptopenjdk --version 11.0.2.9
