package com.myapp.buildlogic.plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: AndroidLibraryViewConventionPlugin
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 *
 */


class AndroidLibraryViewConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            val extension = extensions.getByType(LibraryExtension::class.java)
            configureAndroidViewFoundation(extension)
        }
    }
}