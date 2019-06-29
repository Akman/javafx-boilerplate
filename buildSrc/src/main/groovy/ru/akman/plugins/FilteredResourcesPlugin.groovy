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

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class FilteredResourcesPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.getTasks().create('processResourcesFiltered', FilteredResourcesTask.class, { 
            it.description = 'Process filtered resources'
        });
        project.getTasks().create('processTestResourcesFiltered', FilteredTestResourcesTask.class, { 
            it.description = 'Process filtered test resources'
        });
    }
}

// task processResourcesFiltered(type: Copy) {
//     description = 'Processes filtered resources'
//     sourceSets.main.resources.srcDirs.each {
//         def filteredDir = new File(it, 'filtered')
//         def filtersDir = new File(it, 'filters')
//         def filterFile = new File(filtersDir, 'filter.properties')
//         def filter = new ru.akman.utils.PropertiesMap(filterFile)
//         from filteredDir
//         into sourceSets.main.output.resourcesDir
//         expand filter.properties + project.properties + System.properties
//     }
// }

// processResourcesFiltered {
//     include 'filtered/'
//     filters = [
//       'filters/filter.properties'
//     ]
// }

class FilteredResourcesTask extends DefaultTask {
    @TaskAction
    void processResourcesFiltered() {
        println 'processResourcesFiltered()'
    }
}

// task processTestResourcesFiltered(type: Copy) {
//     description = 'Processes filtered test resources'
//     sourceSets.test.resources.srcDirs.each {
//         def filteredDir = new File(it, 'filtered')
//         def filtersDir = new File(it, 'filters')
//         def filterFile = new File(filtersDir, 'filter.properties')
//         def filter = new ru.akman.utils.PropertiesMap(filterFile)
//         from filteredDir
//         into sourceSets.test.output.resourcesDir
//         expand filter.properties + project.properties + System.properties
//     }
// }

// processTestResourcesFiltered {
//     include 'filtered/'
//     filters = [
//       'filters/filter.properties'
//     ]
// }

class FilteredTestResourcesTask extends DefaultTask {
    @TaskAction
    void processTestResourcesFiltered() {
        println 'processTestResourcesFiltered()'
    }
}
