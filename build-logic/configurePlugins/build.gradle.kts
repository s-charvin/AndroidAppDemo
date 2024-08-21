import org.gradle.internal.impldep.com.fasterxml.jackson.annotation.JsonTypeInfo.Id
apply(from = file("../../versions.gradle.kts"))

plugins {
    `kotlin-dsl`
}

java.apply {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    println(extra.properties)
    val androidGradlePlugin: String by extra
    compileOnly(androidGradlePlugin)
    compileOnly(extra["androidToolsCommon"] as String)
    compileOnly(extra["composeGradlePlugin"] as String)
    compileOnly(extra["firebaseCrashlyticsPlugin"] as String)
    compileOnly(extra["firebasePerformancePlugin"] as String)
    compileOnly(extra["kotlinGradlePlugin"] as String)
    compileOnly(extra["kspGradlePlugin"] as String)
    compileOnly(extra["roomGradlePlugin"] as String)
}

tasks {
    validatePlugins {
        enableStricterValidation.set(true)
        failOnWarning.set(true)
    }
}

gradlePlugin.plugins.apply {
    register("simple-plugin") {
        id = "com.myapp.buildlogic.plugins.simple-plugin"
        implementationClass = "com.myapp.buildlogic.plugins.SimplePlugin"
    }

    register("androidGradlePlugin") {
        id = "com.myapp.buildlogic.plugins.androidGradlePlugin"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidGradlePlugin"
    }

    register("androidApplicationCompose") {
        id = "myapp.android.application.compose"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidApplicationComposeConventionPlugin"
    }
    register("androidApplication") {
        id = "myapp.android.application"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidApplicationConventionPlugin"
    }
    register("androidApplicationJacoco") {
        id = "myapp.android.application.jacoco"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidApplicationJacocoConventionPlugin"
    }
    register("androidLibraryCompose") {
        id = "myapp.android.library.compose"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidLibraryComposeConventionPlugin"
    }
    register("androidLibrary") {
        id = "myapp.android.library"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidLibraryConventionPlugin"
    }
    register("androidFeature") {
        id = "myapp.android.feature"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidFeatureConventionPlugin"
    }
    register("androidLibraryJacoco") {
        id = "myapp.android.library.jacoco"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidLibraryJacocoConventionPlugin"
    }
    register("androidTest") {
        id = "myapp.android.test"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidTestConventionPlugin"
    }
    register("hilt") {
        id = "myapp.hilt"
        implementationClass = "com.myapp.buildlogic.plugins.HiltConventionPlugin"
    }
    register("androidRoom") {
        id = "myapp.android.room"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidRoomConventionPlugin"
    }
    register("androidFirebase") {
        id = "myapp.android.application.firebase"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidApplicationFirebaseConventionPlugin"
    }
    register("androidFlavors") {
        id = "myapp.android.application.flavors"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidApplicationFlavorsConventionPlugin"
    }
    register("androidLint") {
        id = "myapp.android.lint"
        implementationClass = "com.myapp.buildlogic.plugins.AndroidLintConventionPlugin"
    }
    register("jvmLibrary") {
        id = "myapp.jvm.library"
        implementationClass = "com.myapp.buildlogic.plugins.JvmLibraryConventionPlugin"
    }
}
