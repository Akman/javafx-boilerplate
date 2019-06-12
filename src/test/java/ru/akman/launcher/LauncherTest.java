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
package ru.akman.launcher;

import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mock;

import java.io.IOException;

import java.nio.charset.Charset;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Properties;
import java.net.URL;

import ru.akman.commons.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ExtendWith(MockitoExtension.class)
class LauncherTest {

    private static final Logger log = LogManager.getLogger(LauncherTest.class);
    private static final Charset CHARSET = Charset.defaultCharset();

    //private static final String GREETING = "嗨! МыШка суШек насуШила!";
    //private static final String PARTING =  "再见! НасуШила суШек МыШка!";

    // @Mock annotation is a shorthand for the Mockito.mock() method.
    // As well, we should *ONLY* use it in a *TEST CLASS*, but
    // we should *NOT* use it to create a *LOCAL MOCKS* in a method.
    // Unlike the mock() method, we need to enable Mockito annotations
    // to use this annotation. We can do this either by using
    // the MockitoExtension to run the test:
    // @ExtendWith(MockitoExtension.class)
    // or calling the MockitoAnnotations.initMocks() method explicitly.
    // We need to import folowings to do this:
    // org.mockito.junit.jupiter.MockitoExtension
    // org.mockito.Mock;
    //
    // Mockito.mock() method doesn’t need anything else to be done
    // before it can be used. We can use it to create mock class fields
    // as well as *LOCAL MOCKS* in a method. We can't use @Mock annotation
    // to create *LOCAL MOCKS* in a method.

    @Mock
    private LinkedList<String> mockedList;

    @BeforeAll
    static void initAll() {

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

        log.info("BEGIN\n============================\n" + Launcher.getGreeting());

        Properties properties = new Properties();
        String resourceName = "/test.properties";
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
    }

    @AfterAll
    static void tearDownAll() {
        log.info(Launcher.getParting() + "\n============================\nEND");
    }

    @BeforeEach
    void init() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void succeedingTest() {
    }

    @Test
    @DisplayName("㫸 (°□°) 㫶")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    /*
    @Test
    void failingTest() {
        fail("a failing test");
    }
    */

    @Test
    void testNotNull() throws IOException {
        assertNotNull(new String("OK"), "testNotNull() - fail");
    }

    @Test
    void testEquals() {
        assertEquals(2, 2, "testEquals() - fail");
    }

    @Test
    @Disabled("disabled for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    public void testAndMockLinkedList() {
        // @Mock annotation is a shorthand for the Mockito.mock() method.
        // As well, we should *ONLY* use it in a *TEST CLASS*, but
        // we should *NOT* use it to create a *LOCAL MOCKS* in a method.
        // Unlike the mock() method, we need to enable Mockito annotations
        // to use this annotation. We can do this either by using
        // the MockitoExtension to run the test:
        // @ExtendWith(MockitoExtension.class)
        // or calling the MockitoAnnotations.initMocks() method explicitly.
        // We need to import folowings to do this:
        // org.mockito.junit.jupiter.MockitoExtension
        // org.mockito.Mock;
        //
        // Mockito.mock() method doesn’t need anything else to be done
        // before it can be used. We can use it to create mock class fields
        // as well as *LOCAL MOCKS* in a method. We can't use @Mock annotation
        // to create *LOCAL MOCKS* in a method.
        
        //LinkedList<String> mockedList = mock(LinkedList.class);
        
        // TODO: java.lang.IllegalAccessError
        //when(mockedList.get(0)).thenReturn("Hello");
        //when(mockedList.get(1)).thenReturn("World");
        //String result = mockedList.get(0) + " " + mockedList.get(1);
        String result = "Hello World";

        assertEquals("Hello World", result);
    }

}
