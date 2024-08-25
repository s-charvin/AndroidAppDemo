package com.myapp.buildlogic.plugins

import org.gradle.api.Project
import com.android.build.api.dsl.CommonExtension

/**
 * 配置 Android View 基础库
 */
internal fun Project.configureAndroidViewFoundation(
    extension: CommonExtension<*, *, *, *, *, *, *, *>,
) {
    extension.apply {
        buildFeatures {
            viewBinding = true
        }

        dependencies.add("implementation", Libraries.androidxCoreKtx)
        dependencies.add("implementation", Libraries.androidxAppCompat)
        dependencies.add("implementation", Libraries.googleMaterial)
        dependencies.add("implementation",Libraries.androidConstraintlayout)
        dependencies.add("implementation", Libraries.androidxLifecycleViewmodelKtx)
        dependencies.add("implementation", Libraries.androidxLifecycleLivedataKtx)
        dependencies.add("implementation", Libraries.androidxLifecycleRuntimeKtx)
    }
}

/**
 * 配置 Android View 动画库
 */
internal fun Project.configureAndroidViewAnimation(
    extension: CommonExtension<*, *, *, *, *, *, *, *>,
) {

}

/**
 * 配置 Android View UI 库
 */
internal fun Project.configureAndroidViewUI(
    extension: CommonExtension<*, *, *, *, *, *, *, *>,
) {

}

/**
 * 配置 Android View 生命周期库
 */
internal fun Project.configureAndroidViewLifecycle(
    extension: CommonExtension<*, *, *, *, *, *, *, *>,
) {

}