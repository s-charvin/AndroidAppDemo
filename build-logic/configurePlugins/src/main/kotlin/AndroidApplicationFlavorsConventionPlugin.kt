package com.myapp.buildlogic.plugins

/*
 * Project: MyApplication
 * File: AndroidApplicationFlavorsConventionPlugin
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("UnstableApiUsage")
class AndroidApplicationFlavorsConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType(ApplicationExtension::class.java)
            configureFlavors(extension)
        }
    }
}