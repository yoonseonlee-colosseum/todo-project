import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	kotlin("plugin.jpa")
}

description = "skeleton-domain"

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

val queryDslVersion: String by project.extra

dependencies {
	api(project(":skeleton-infra"))

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.querydsl:querydsl-jpa:$queryDslVersion")

	kapt("com.querydsl:querydsl-apt:$queryDslVersion")
	kapt("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<Jar> {
	enabled = true
}

tasks.withType<BootJar> {
	enabled = false
}
