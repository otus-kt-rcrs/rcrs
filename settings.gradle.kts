rootProject.name = "rcrs"
include("m1l1")
include("crm")
include("rcrs-context")
include("rcrs-v1-mapper")
include("rcrs-api-v1-jackson")

pluginManagement {
    val kotlinVersion: String by settings
    val openapiVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion apply false
        id("org.openapi.generator") version openapiVersion apply false
    }
}
