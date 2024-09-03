package com.myapp.buildlogic.plugins

import Libraries
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: AndroidFeatureConventionPlugin
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */

class AndroidFeatureConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply{
                apply("myapp.android.library")
                apply("myapp.hilt")
            }

            extensions.configure(LibraryExtension::class.java) {
                it.testOptions.animationsDisabled = true
            }

            dependencies.add("implementation", project(":core:ui-foundation"))
            dependencies.add("implementation", project(":core:ui-components"))
            dependencies.add("implementation", Libraries.androidxTracingKtx)
        }
    }
}