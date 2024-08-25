package com.myapp.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: JvmLibraryConventionPlugin
 *
 * Created by: charvin on 8/26/24.
 * Last modified by: charvin on 8/26/24.
 *
 * Description:
 * 
 */


class JvmLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
            }
            configureKotlinJvm()
        }
    }
}