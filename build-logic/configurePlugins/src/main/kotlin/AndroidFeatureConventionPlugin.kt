package com.myapp.buildlogic.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

/*
 * Project: MyApplication
 * File: AndroidFeatureConventionPlugin
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */

class AndroidFeatureConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply{

            }
        }
    }
}