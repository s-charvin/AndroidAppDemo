package com.myapp.buildlogic.plugins

import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: AndroidRoomConventionPlugin
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */




class AndroidRoomConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("androidx.room")
                apply("com.google.devtools.ksp")
            }
            extensions.configure(KspExtension::class.java) {
//                it.arg("room.schemaLocation", "$projectDir/schemas")
                it.arg("room.generateKotlin", "true")
            }

            dependencies.add("implementation", Libraries.roomRuntime)
            dependencies.add("implementation", Libraries.roomKtx)
            dependencies.add("ksp", Libraries.roomCompiler)
        }
    }
}