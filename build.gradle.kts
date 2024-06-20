plugins {
    alias(libs.plugins.springboot.dependency.management)
    alias(libs.plugins.springboot)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spotless)
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.jvmTarget.get()))
        target { JavaLanguageVersion.of(libs.versions.jvmTarget.get()) }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.springboot.all)
    implementation(libs.bundles.kotlin.all)
}

tasks {
    jar {
        enabled = false
    }

    build {
        finalizedBy(spotlessApply)
    }

    test {
        useJUnitPlatform()
        finalizedBy(spotlessApply)
    }
}

val tasksDependencies = mapOf(
    "spotlessKotlin" to listOf("compileKotlin", "compileTestKotlin", "test")
)

tasksDependencies.forEach { (taskName, dependencies) ->
    tasks.findByName(taskName)?.dependsOn(dependencies)
}
