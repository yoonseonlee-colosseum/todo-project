description = "skeleton-api"

dependencies {
	implementation(project(":skeleton-domain"))
	implementation("org.springframework.boot:spring-boot-starter-web")

	runtimeOnly("com.h2database:h2")
	testImplementation("com.h2database:h2")
}

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
	enabled = true
	mainClass.set("kr.skeleton.api.ApplicationKt")
}

tasks.withType<Jar> {
	enabled = false
}
