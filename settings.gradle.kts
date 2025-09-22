rootProject.name = "skeleton"

include(
	"skeleton-api",
	"skeleton-domain",
)

pluginManagement {
	val kotlinVersion: String by settings
	val springBootVersion: String by settings
	val springDependencyManagementVersion: String by settings
	val ktlintVersion: String by settings
	val querydslVersion: String by settings
	val p6spyVersion: String by settings

	resolutionStrategy {
		eachPlugin {
			when (requested.id.id) {
				"org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
				"org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
				"org.springframework.boot" -> useVersion(springBootVersion)
				"io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
				"org.jlleitschuh.gradle.ktlint" -> useVersion(ktlintVersion)
			}
		}
	}
}
