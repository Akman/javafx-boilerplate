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
package ru.akman.cli;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * App
 *
 */
public class App {
    
    private static final Logger log = LogManager.getLogger(App.class);

    private static final Charset CHARSET = Charset.defaultCharset();

    public static void launch(String... args) throws IOException {
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in, CHARSET));
        String line;
        int length;
        while ((line = reader.readLine()) != null) {
            length = line.length();
            if (length == 0) {
                break;
            }
            String bytes = Arrays.toString(line.getBytes(CHARSET));
            log.debug("length: " + length);
            log.debug("string: '" + line + "'");
            log.debug("bytes: " + bytes);
            System.out.printf("length: %d\n", length);
            System.out.printf("string: '%s'\n", line);
            System.out.printf("bytes: %s\n", bytes);
        }
    }

}
