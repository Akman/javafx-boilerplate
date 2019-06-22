/**
 * The MIT License (MIT)
 *
 * Copyright (C) 2019 Alexander Kapitman <akman.ru@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

class PropertiesFile {
    private File file
    private String encoding
    private Map propertiesMap = [:]
    PropertiesFile(File file, String encoding = 'UTF-8') {
        this.file = file
        this.encoding = encoding
    }
    PropertiesFile(String fileName, String encoding = 'UTF-8') {
        this(new File(fileName), encoding)
    }
    Map getProperties() {
        if (!propertiesMap) {
            Properties properties = new Properties()
            properties.load(new InputStreamReader(
                new FileInputStream(this.file), this.encoding))
            properties.each { name, value -> propertiesMap.put(name, value) }
        }
        return propertiesMap
   }
}
