/*
  JavaFX Boilerplate Project

  https://github.com/akman/javafx-boilerplate

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

package ru.akman.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.akman.launcher.Launcher;

/**
 * CLI interface.
 */
public final class LauncherHelper {

  /**
   * Default logger.
   */
  private static final Logger LOG =
      LoggerFactory.getLogger(LauncherHelper.class);

  private LauncherHelper() {
    // not called
    throw new UnsupportedOperationException();
  }

  /**
   * CLI Application launcher.
   */
  public static void run() {
    if (LOG.isInfoEnabled()) {
      LOG.info(Launcher.getString("app.starting"));
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
        System.in, Charset.defaultCharset()))) {
      while (true) {
        final String line = reader.readLine();
        if (line == null) {
          break;
        }
        final int length = line.length();
        if (length == 0) {
          break;
        }
        if (LOG.isDebugEnabled()) {
          LOG.debug("length: {}", length);
          LOG.debug("string: '{}'", line);
          LOG.debug("bytes: {}", Arrays.toString(
              line.getBytes(Charset.defaultCharset())));
        }
        System.out.println(line);
      }
    } catch (IOException ex) {
      if (LOG.isErrorEnabled()) {
        LOG.error("IO Exception", ex);
      }
    }
  }

}
