/*
  JavaFX Boilerplate Project

  https://github.com/akman/java-boilerplate-gradle

  MIT License (MIT)

  Copyright (C) 2019 - 2021 Alexander Kapitman <akman.ru@gmail.com>

  Permission is hereby granted, free of charge, to any person obtaining
  a copy of this software and associated documentation files (the "Software"),
  to deal in the Software without restriction, including without limitation
  the rights to use, copy, modify, merge, publish, distribute, sublicense,
  and/or sell copies of the Software, and to permit persons to whom
  the Software is furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included
  in all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL
  THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
  DEALINGS IN THE SOFTWARE.
*/
package ru.akman.utils

import groovy.transform.CompileStatic

/**
 * Properties map that supports user encoding for properties files.
 */
@CompileStatic
class PropertiesMap {

  private final File file
  private final String encoding
  private final Map map = [:]

  PropertiesMap(File file, String encoding = 'UTF-8') {
    this.file = file
    this.encoding = encoding
  }

  PropertiesMap(String fileName, String encoding = 'UTF-8') {
    // The use of java.io.File violates the Enterprise Java Bean specification
    this(new File(fileName), encoding)
  }

  Map getProperties() {
    if (!map) {
      Properties properties = new Properties()
      properties.load(new InputStreamReader(
          new FileInputStream(this.file), this.encoding))
      properties.each { key, value -> map[key] = value }
    }
    map
  }

}
