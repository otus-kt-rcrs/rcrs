plugins {
    kotlin("jvm")
    application
    checkstyle
}

dependencies {
    testImplementation(kotlin("test-junit"))
}

checkstyle {
    toolVersion = "8.15"
    configFile = file("config/checkstyle/checkstyle.xml")
    isIgnoreFailures = true
}
