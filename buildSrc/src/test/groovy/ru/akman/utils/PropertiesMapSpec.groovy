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
package ru.akman.utils

import spock.lang.Specification

/**
 * One specification class per class testing
 * One test per method
 *   - each unique non-empty constructor counts as a method
 * One test per method that can throw an exception
 *   - because testing logic for exceptions typically doesn't complement
 *     normal testing logic
 * One test iteration per input combination
 */
class PropertiesMapSpec extends Specification {
    
    def propertiesMap = null

    def setup() {
        def file = new File(getClass().getResource('/test.properties').toURI())
        propertiesMap = new PropertiesMap(file)
    }

    def "size"() {
        expect:
            propertiesMap != null
            propertiesMap.properties.size() == 2
    }
    
    def "greeting"() {
        expect:
            propertiesMap.properties['messages.greeting'] == '再 - Hello!'
    }
    
    def "parting"() {
        expect:
            propertiesMap.properties['messages.parting'] == '见 - Good Bye!'
    }
}
