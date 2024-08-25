package com.myapp.buildlogic.plugins

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.compile.GroovyCompile
import org.gradle.api.tasks.compile.JavaCompile

/*
 * Project: MyApplication
 * File: ConfigureKotlinAndroid
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */


@Suppress("UnstableApiUsage")
internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *, *, *>,
) {
    commonExtension.apply {
        compileSdk = Configs.compileSdk
        defaultConfig.minSdk = Configs.minSdk

        compileOptions {
            sourceCompatibility = JavaVersion.toVersion(Configs.compileCompatibility)
            targetCompatibility = JavaVersion.toVersion(Configs.compileCompatibility)
//            isCoreLibraryDesugaringEnabled = true
        }
    }

    configureKotlin()
    // 如果需要使用 Java 11 的 API，需要添加以下依赖
//    dependencies.add("coreLibraryDesugaring", libs.findLibrary("android.desugarJdkLibs").get())
}

/**
 * 配置 JVM 项目的 Kotlin 选项
 */

internal fun Project.configureKotlinJvm() {
    extensions.configure(JavaPluginExtension::class.java) {
        it.sourceCompatibility = JavaVersion.toVersion(Configs.compileCompatibility)
        it.targetCompatibility = JavaVersion.toVersion(Configs.compileCompatibility)
    }
}

internal fun Project.configureKotlin() {
    // 低版本插件不支持 Kotlin 插件的配置
}