package com.example.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class VersionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("VersionPlugin")
    }
}

