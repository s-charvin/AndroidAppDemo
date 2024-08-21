plugins {
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(extra["googleOssLicensesPlugin"] as String) {
            exclude(group = "com.google.protobuf")
        }
    }
}

allprojects {
    repositories {
        google()
    }
}


subprojects {
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
