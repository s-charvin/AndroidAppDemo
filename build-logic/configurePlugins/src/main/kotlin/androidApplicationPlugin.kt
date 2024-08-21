package com.myapp.buildlogic.plugins

import Libraries
import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello") {
            println("Hello from the GreetingPlugin")
        }
    }
}

class SimplePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("SimplePlugin")
    }
}

class AndroidGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        // buildscript.dependencies.add("classpath", Libraries.androidGradlePlugin)
        target.dependencies.add("classpath", Libraries.androidGradlePlugin)
    }
}