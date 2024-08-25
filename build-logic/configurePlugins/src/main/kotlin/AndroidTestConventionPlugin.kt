package com.myapp.buildlogic.plugins

import com.android.build.gradle.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: AndroidTestConventionPlugin
 *
 * Created by: charvin on 8/26/24.
 * Last modified by: charvin on 8/26/24.
 *
 * Description:
 * 
 */


class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure(TestExtension::class.java) {
                configureKotlinAndroid(it)
                it.defaultConfig.targetSdk = Configs.targetSdk
            }
        }
    }
}