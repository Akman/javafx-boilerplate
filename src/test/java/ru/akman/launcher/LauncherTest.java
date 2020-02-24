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

package ru.akman.launcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.fail;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
// import java.util.LinkedList;
import java.util.Properties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.mockito.Mock;
import ru.akman.commons.CommonUtils;

/**
 * Tests for ru.akman.launcher.Launcher class.
 */
@ExtendWith(MockitoExtension.class)
class LauncherTest {

  /**
   * Default logger.
   */
  private static final Logger LOG = LogManager.getLogger(LauncherTest.class);

  /**
   * Application properties from properties file.
   */
  private static final Properties PROPERTIES = CommonUtils.loadResource(
      "/test.properties", Charset.defaultCharset());

  static {
    CommonUtils.setupSystemStreams();
    // configuration: /log4j2-test.xml
    // ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
    Configurator.setRootLevel(Level.ERROR);
    Configurator.setLevel(LauncherTest.class.getName(), Level.INFO);
  }

  // PMD: Each class should declare at least one constructor

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

  // @Mock
  // private LinkedList<String> mockedList;

  @BeforeAll
  /* default */ static void initAll() {
    if (LOG.isInfoEnabled()) {
      LOG.info(Launcher.getString("app.greeting"));
      LOG.info("locale = " + Locale.getDefault());
      LOG.info("charset = " + Charset.defaultCharset());
      LOG.info("file.encoding = " + System.getProperty("file.encoding"));
    }
    PROPERTIES.stringPropertyNames().forEach(name -> {
      if (LOG.isInfoEnabled()) {
        LOG.info(name + " = " + PROPERTIES.getProperty(name));
      }
    });
  }

  @AfterAll
  /* default */ static void tearDownAll() {
    if (LOG.isInfoEnabled()) {
      LOG.info(Launcher.getString("app.parting"));
    }
  }

  @BeforeEach
  /* default */ void init() {
    //
  }

  @AfterEach
  /* default */ void tearDown() {
    //
  }

  @Test
  /* default */ void succeedingTest() {
    assertNotNull("NOT NULL", "succeedingTest() - fail");
  }

  @Test
  @DisplayName("㫸 (°□°) 㫶")
  /* default */ void testWithDisplayNameContainingSpecialCharacters() {
    assertNotNull("NOT NULL", "testWithDisplayNameContainingSpecialCharacters() - fail");
  }

  // @Test
  // void failingTest() {
  //     fail("a failing test");
  // }

  @Test
  /* default */ void testNotNull() throws IOException {
    assertNotNull("OK", "testNotNull() - fail");
  }

  @Test
  /* default */ void testEquals() {
    assertEquals(2, 2, "testEquals() - fail");
  }

  @Test
  @Disabled("disabled for demonstration purposes")
  /* default */ void skippedTest() {
    assertNotNull("NOT NULL", "skippedTest() - fail");
  }


  @Test
  /* default */ void testAndMockLinkedList() {
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

    // ERROR: java.lang.IllegalAccessError
    //when(mockedList.get(0)).thenReturn("Hello");
    //when(mockedList.get(1)).thenReturn("World");
    //String result = mockedList.get(0) + " " + mockedList.get(1);
    final String result = "Hello World";

    assertEquals("Hello World", result, "testAndMockLinkedList() - fail");
  }

}
