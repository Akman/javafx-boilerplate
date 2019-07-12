/**
 * Java Boilerplate Project
 *
 * https://github.com/akman/java-boilerplate-gradle
 *
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
package ru.akman.commons;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utils
 *
 */
public class Utils {

    public static String getDefaultEncoding() {
        final byte [] bytes = {'A'};
        final InputStream inputStream = new ByteArrayInputStream(bytes);
        final InputStreamReader reader = new InputStreamReader(inputStream);
        final String encoding = reader.getEncoding();
        return encoding;
    }

}
