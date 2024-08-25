package com.myapp.buildlogic.plugins

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.Locale

/*
 * Project: MyApplication
 * File: AndroidLibraryConventionPlugin
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */


class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply{
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure(LibraryExtension::class.java) {
                configureKotlinAndroid(it)
                it.defaultConfig.targetSdk = Configs.targetSdk
                it.defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                it.testOptions.animationsDisabled = true
                configureFlavors(it)
                // 使得资源前缀取决于模块名称, 例如 `:core:module1` 内的资源以 `core_module1_`为前缀
                it.resourcePrefix = path.split("""\W""".toRegex()).drop(1).distinct().joinToString(separator = "_").toLowerCase(
                    Locale.ROOT) + "_"
            }

            dependencies.add("androidTestImplementation", Libraries.kotlinTest)
            dependencies.add("testImplementation", Libraries.kotlinTest)
            dependencies.add("implementation", Libraries.androidxTracingKtx)
        }
    }
}