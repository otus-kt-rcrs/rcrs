plugins {
    kotlin("jvm")
    checkstyle
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

subprojects {
    group = "ru.rcrs"
    version = "1.0-SNAPSHOT"

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}

checkstyle {
    toolVersion = "10.3.3"
    config = rootProject.resources.text.fromFile("config/checkstyle/checkstyle.xml")
}
