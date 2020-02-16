/*
  Java Boilerplate Project

  https://github.com/akman/java-boilerplate-gradle

  The MIT License (MIT)

  Copyright (C) 2019 - 2020 Alexander Kapitman <akman.ru@gmail.com>

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

package ru.akman.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * CLI interface.
 */
public final class LauncherHelper {

  /**
   * Default logger.
   */
  private static final Logger LOG = LogManager.getLogger(LauncherHelper.class);

  /**
   * Default charset.
   */
  private static final Charset CHARSET = Charset.defaultCharset();

  private LauncherHelper() {
    // not called
    throw new UnsupportedOperationException();
  }

  /**
   * CLI Application launcher.
   * @param args CLI arguments
   */
  public static void run(final String... args) {
    LOG.info("Launching application ...");
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, CHARSET))) {
      while (true) {
        final String line = reader.readLine();
        if (line == null) {
          break;
        }
        final int length = line.length();
        if (length == 0) {
          break;
        }
        final String bytes = Arrays.toString(line.getBytes(CHARSET));
        if (LOG.isDebugEnabled()) {
          LOG.debug("length: " + length);
          LOG.debug("string: '" + line + "'");
          LOG.debug("bytes: " + bytes);
        }
        System.out.printf("length: %d%n", length);
        System.out.printf("string: '%s'%n", line);
        System.out.printf("bytes: %s%n", bytes);
      }
    } catch (IOException ex) {
      LOG.error(ex);
    }
  }

}