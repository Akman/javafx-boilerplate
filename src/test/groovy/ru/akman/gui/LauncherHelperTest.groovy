/*
  JavaFX Boilerplate Project

  https://github.com/akman/javafx-boilerplate

  MIT License (MIT)

  Copyright (C) 2019 - 2024 Alexander Kapitman <akman.ru@gmail.com>

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
package ru.akman.gui

import groovy.transform.CompileDynamic
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Shared
import spock.lang.Specification

/**
 * One specification class per class testing.
 * One test per method
 *   - each unique non-empty constructor counts as a method
 * One test per method that can throw an exception
 *   - because testing logic for exceptions typically doesn't complement
 *     normal testing logic
 * One test iteration per input combination
 */
@CompileDynamic
class LauncherHelperTest extends Specification {

  /**
   * To share an object between feature methods declare a @Shared field.
   *
   * Again it’s best to initialize the field right at the point of
   * declaration.
   * Semantically, this is equivalent to initializing the field at the very
   * beginning of the setupSpec() method.
   * Note that setupSpec() and cleanupSpec() may not reference
   * instance fields UNLESS they are annotated with @Shared.
   */
  @Shared
  Logger logger = LoggerFactory.getLogger(LauncherHelperTest)

  /**
   * Instance fields are a good place to store objects belonging to
   * the specification’s fixture. It is good practice to initialize them
   * right at the point of declaration.
   * Semantically, this is equivalent to initializing them at the very
   * beginning of the setup() method.
   * Objects stored into instance fields are NOT SHARED between feature
   * methods. Instead, every feature method gets its own object.
   * This helps to isolate feature methods from each other, which is often
   * a desirable goal.
   */

  /**
   * Static fields should only be used for constants.
   * Otherwise shared fields are preferable, because their semantics with
   * respect to sharing are more well-defined.
   */

  /**
   * Runs once -  before the FIRST feature method.
   */
  def setupSpec() {
    // configuration: /log4j2-test.xml
    // ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
    // Configurator.setRootLevel(Level.DEBUG);
    logger.debugEnabled &&
      logger.debug('Runs once -  before the FIRST feature method.')
  }

  /**
   * Runs before EVERY feature method.
   */
  def setup() {
    logger.debugEnabled &&
      logger.debug('Runs before EVERY feature method.')
  }

  def 'По русски: LauncherHelperTest expects true'() {
    expect:

    true
  }

  /**
   * Runs after EVERY feature method.
   */
  def cleanup() {
    logger.debugEnabled &&
      logger.debug('Runs after EVERY feature method.')
  }

  /**
   * Runs once -  after the LAST feature method.
   */
  def cleanupSpec() {
    logger.debugEnabled &&
      logger.debug('Runs once -  after the LAST feature method.')
  }

}
