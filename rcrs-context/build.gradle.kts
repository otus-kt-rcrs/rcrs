plugins {
    kotlin("jvm")
    application
}

group = rootProject.group
version = rootProject.version

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}