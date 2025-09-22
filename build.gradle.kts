import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm")
	kotlin("kapt") version "1.9.10"
	kotlin("plugin.spring") apply false
	id("org.springframework.boot") apply false
	id("io.spring.dependency-management") apply false
	id("org.jlleitschuh.gradle.ktlint") version "12.1.1"
}

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

val projectGroup: String by project
val applicationVersion: String by project

allprojects {
	group = projectGroup
	version = applicationVersion

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "org.jetbrains.kotlin.kapt")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jlleitschuh.gradle.ktlint")

	val p6spyVersion: String by project.extra
	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:$p6spyVersion")

		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	}

	tasks.withType<KotlinCompile> {
		compilerOptions {
			freeCompilerArgs.set(listOf("-Xjsr305=strict"))
			jvmTarget.set(JvmTarget.JVM_21)
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}
