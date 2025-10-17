plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.spring") apply false
    kotlin("plugin.jpa") apply false
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
    id("com.colosseum.code-quality") version "2.1.1"
    id("com.diffplug.spotless") version "6.25.0" apply false // 버전만 명시
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmToolchain(21)
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    val p6spyVersion: String by project.extra

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:$p6spyVersion")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    }

    plugins.withId("com.diffplug.spotless") {
        spotless {
            ratchetFrom("HEAD")
        }
    }
}
