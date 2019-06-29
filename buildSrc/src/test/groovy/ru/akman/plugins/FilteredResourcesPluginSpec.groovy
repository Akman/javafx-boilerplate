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
package ru.akman.plugins

import spock.lang.Specification

import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project

// https://docs.gradle.org/current/userguide/test_kit.html
// https://docs.gradle.org/current/userguide/test_kit.html#example_using_gradlerunner_with_spock

/**
 * One specification class per class testing
 * One test per method
 *   - each unique non-empty constructor counts as a method
 * One test per method that can throw an exception
 *   - because testing logic for exceptions typically doesn't complement
 *     normal testing logic
 * One test iteration per input combination
 */
class FilteredResourcesPluginSpec extends Specification {

    Project project = ProjectBuilder.builder().build()

    def setup() {
        project.pluginManager.apply FilteredResourcesPlugin.class
    }

    def "Task processResourcesFiltered is instance of FilteredResourcesTask"() {
        expect:
            project.tasks.processResourcesFiltered instanceof FilteredResourcesTask
    }

    def "Task processTestResourcesFiltered is instance of FilteredTestResourcesTask"() {
        expect:
            project.tasks.processTestResourcesFiltered instanceof FilteredTestResourcesTask
    }

}