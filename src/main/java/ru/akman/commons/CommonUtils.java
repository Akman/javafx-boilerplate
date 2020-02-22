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

package ru.akman.commons;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Properties;
import org.apache.logging.log4j.Logger;

/**
 * Utils.
 */
public final class CommonUtils {

  private CommonUtils() {
    // not called
    throw new UnsupportedOperationException();
  }

  /**
   * Get historical name for system default encoding by reading
   * byte array as input stream.
   * @return historical name for system default encoding,
   *         or null if IO error occurs
   */
  public static String getDefaultEncoding() {
    final InputStreamReader reader = new InputStreamReader(
        new ByteArrayInputStream(new byte[] { 'A' }),
        Charset.defaultCharset());
    return reader.getEncoding();
  }

  /**
   * Dump default encoding, locale and charset.
   * @param log logger used to dump values
   */
  public static void dumpEncoding(final Logger log) {
    if (log.isDebugEnabled()) {
      log.debug("file.encoding: "
          + System.getProperty("file.encoding"));
      log.debug("sun.jnu.encoding: "
          + System.getProperty("sun.jnu.encoding"));
      log.debug("Default encoding: "
          + getDefaultEncoding());
      log.debug("Default locale: "
          + Locale.getDefault());
      log.debug("Default charset: "
          + Charset.defaultCharset().name());
    }
  }

  /**
   * Load resource by name and charset.
   * @param resourceName resource name (path)
   * @param resourceCharset resource charset
   * @return properties object
   * @throws IOException if can't load resource
   */
  public static Properties loadResource(final String resourceName,
      final Charset resourceCharset) throws IOException {
    final URL resourceUrl = CommonUtils.class.getResource(resourceName);
    if (resourceUrl == null) {
      throw new IOException("Resource not found: '" + resourceName + "'");
    }
    final Properties properties = new Properties();
    try (InputStreamReader isr = new InputStreamReader(
        resourceUrl.openStream(), resourceCharset)) {
      properties.load(isr);
    }
    return properties;
  }

}
