package com.myapp.buildlogic.plugins

import com.android.build.gradle.api.AndroidBasePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: HiltConventionPlugin
 *
 * Created by: charvin on 8/26/24.
 * Last modified by: charvin on 8/26/24.
 *
 * Description:
 * 
 */


class HiltConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")

            /** Add support for Android modules, based on [AndroidBasePlugin] */
            pluginManager.withPlugin("com.android.base") {
                pluginManager.apply("dagger.hilt.android.plugin")
                dependencies.add("implementation", Libraries.hiltAndroid)
            }

            dependencies.add("ksp", Libraries.hiltCompiler)
            dependencies.add("implementation", Libraries.hiltCore)
        }
    }
}