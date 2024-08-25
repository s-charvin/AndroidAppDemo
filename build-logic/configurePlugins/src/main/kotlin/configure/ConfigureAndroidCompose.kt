package com.myapp.buildlogic.plugins

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: ConfigureAndroidCompose
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */



internal fun Project.configureAndroidCompose(
    extension: CommonExtension<*, *, *, *, *, *, *, *>,
) {
    @Suppress("UnstableApiUsage")
    extension.apply {
        buildFeatures {
            compose = true
        }

        dependencies.add("implementation", Libraries.androidxComposeBom)
        dependencies.add("androidTestImplementation", Libraries.androidxComposeBom)
        dependencies.add("implementation", Libraries.androidxComposeUiToolingPreview)
        dependencies.add("debugImplementation", Libraries.androidxComposeUiTooling)

        testOptions {
            unitTests.isIncludeAndroidResources = true
        }
    }
}