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
package ru.akman.launcher;

import java.io.IOException;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import ru.akman.commons.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Launcher
 *
 */
public class Launcher {

    private static final Logger log = LogManager.getLogger(Launcher.class);

    private static final Charset CHARSET = Charset.defaultCharset();

    private static ResourceBundle messages =
        ResourceBundle.getBundle("messages", Locale.getDefault());

    public static String getGreeting() {
        return messages.getString("app.greeting");
    }

    public static String getParting() {
        return messages.getString("app.parting");
    }

    public static void main(final String... args) throws IOException {

        log.debug("file.encoding: " +
            System.getProperty("file.encoding"));
        log.debug("sun.jnu.encoding: " +
            System.getProperty("sun.jnu.encoding"));
        log.debug("Default encoding: " +
            Utils.getDefaultEncoding());
        log.debug("Default locale: " +
            Locale.getDefault());
        log.debug("Default charset: " +
            Charset.defaultCharset().name());

        System.setOut(new PrintStream(System.out, true, CHARSET));
        System.setErr(new PrintStream(System.err, true, CHARSET));

        Properties properties = new Properties();
        String resourceName = "/application.properties";
        URL resourceURL = Launcher.class.getResource(resourceName);
        if (resourceURL == null) {
            log.error("Resource not found: '" + resourceName + "'");
        } else {
            log.debug("Loading resource: " + resourceURL);
            try {
                properties.load(
                    new InputStreamReader(resourceURL.openStream(), CHARSET));
            } catch (IOException e) {
                log.error("Can't load resource: " + resourceURL);
            }
        }
        properties.stringPropertyNames().forEach(name -> {
            log.debug(name + " = " + properties.getProperty(name));
        });

        log.debug(getGreeting());
        System.err.println(getGreeting());

        if (args.length > 0 && "--no-gui".equals(args[0])) {
            log.debug("CLI Mode");
            ru.akman.cli.App.launch(args);
        } else {
            log.debug("GUI Mode");
            ru.akman.gui.App.launch(args);
        }

        log.debug(getParting());
        System.err.println(getParting());

    }

}
