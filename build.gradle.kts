plugins {
    kotlin("jvm")
    id("checkstyle")
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {
    apply(plugin = "checkstyle")
    group = "ru.rcrs"
    version = "1.0-SNAPSHOT"

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
    checkstyle {
        toolVersion = "10.3.2"
        isIgnoreFailures = false
        maxWarnings = 0
        maxErrors = 0
        configFile = file("config/checkstyle/checkstyle.xml")
    }
}


