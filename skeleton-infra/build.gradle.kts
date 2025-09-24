import org.springframework.boot.gradle.tasks.bundling.BootJar

description = "skeleton-infra"

dependencies {
	api(libs.poi.ooxml)
	api(libs.skeleton.library.excel)
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
