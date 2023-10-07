rootProject.name = "rcrs"
include("m1l1")
include("crm")

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion apply false
    }
}
