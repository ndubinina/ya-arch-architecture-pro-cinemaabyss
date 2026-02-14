plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    kotlin("plugin.jpa") version "2.2.21"
    id("org.springframework.boot") version "4.0.1"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.openapi.generator") version "7.0.1"
}

group = "ru.arch.cinemaabyss"
version = "0.0.1-SNAPSHOT"
description = "Events service"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Web (Controller)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("tools.jackson.module:jackson-module-kotlin")

    implementation("org.springframework.kafka:spring-kafka")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.7.0")
}

openApiGenerate {
    generatorName.set("kotlin-spring")

    inputSpec.set("../../../api-specification.yaml")
    outputDir.set("$buildDir/generated")

    apiPackage.set("ru.arch.cinemaabyss.proxy.api")
    modelPackage.set("ru.arch.cinemaabyss.proxy.api.model")

    configOptions.set(
        mapOf(
            "useTags" to "true",
            "interfaceOnly" to "true",
            "reactive" to "false",
            "dateLibrary" to "java8",
            "serializationLibrary" to "jackson",
            "useJakarta" to "true"
        )
    )
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
