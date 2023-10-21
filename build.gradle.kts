// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.openapi.generator") version "6.6.0"
    id("com.google.dagger.hilt.android") version "2.44" apply false
    kotlin("plugin.serialization") version "1.8.10" apply false
}

openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set("$rootDir/openapi/spec.yaml")
    outputDir.set("$rootDir/app")
    ignoreFileOverride.set("$rootDir/openapi/openapi-generator-ignore")
    additionalProperties.set(mapOf(
        "useCoroutines" to true,
        "library" to "jvm-retrofit2",
        "serializationLibrary" to "kotlinx_serialization",
        "sourceFolder" to "src/main/java"
    ))
}