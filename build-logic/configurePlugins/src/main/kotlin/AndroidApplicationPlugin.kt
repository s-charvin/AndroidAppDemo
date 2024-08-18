/*
 * Project: My Application
 * File: VersionPlugin
 *
 * Created by: charvin on 8/11/24.
 * Last modified by: charvin on 8/11/24.
 *
 * Description:
 * 
 */

//import com.android.build.api.dsl.ApplicationExtension
//import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
//import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.api.artifacts.VersionCatalogsExtension


class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("com.android.application")
        target.plugins.apply("org.jetbrains.kotlin.android")
//
//        target.extensions.configure<ApplicationExtension> {
//            compileSdk = 34
//            defaultConfig.minSdk = 24
//            defaultConfig.targetSdk = 34
//            compileOptions {
//                sourceCompatibility = JavaVersion.VERSION_17
//                targetCompatibility = JavaVersion.VERSION_17
//                isCoreLibraryDesugaringEnabled = true
//            }
//
//            @Suppress("UnstableApiUsage")
//            testOptions.animationsDisabled = true
//        }
//
        val libs = target.extensions.getByType<VersionCatalogsExtension>().named("libs")
//        target.dependencies.add("coreLibraryDesugaring", libs.findLibrary("android.desugarJdkLibs").get())
        target.dependencies.add("implementation", libs.findLibrary("coreKtx").get())
        target.dependencies.add("implementation", libs.findLibrary("appCompat").get())
        target.dependencies.add("implementation", libs.findLibrary("activityKtx").get())
        target.dependencies.add("implementation", libs.findLibrary("fragmentKtx").get())
    }
}