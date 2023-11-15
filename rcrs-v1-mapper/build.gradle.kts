plugins {
    kotlin("jvm")
    application
}

group = rootProject.group
version = rootProject.version

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib"))
    implementation(project(":rcrs-api-v1-jackson"))
    implementation(project(":rcrs-context"))
}

tasks.test {
    useJUnitPlatform()
}