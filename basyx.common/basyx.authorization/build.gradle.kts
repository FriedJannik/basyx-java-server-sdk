plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    api(libs.org.springframework.boot.spring.boot.starter.security)
    api(libs.org.springframework.boot.spring.boot.actuator.autoconfigure)
    api(libs.org.springframework.boot.spring.boot.starter.oauth2.resource.server)
    api(project(":basyx.http"))
    api(libs.org.springframework.boot.spring.boot.starter.validation)
    api(libs.com.fasterxml.jackson.core.jackson.databind)
    api(libs.org.apache.commons.commons.lang3)
    api(project(":basyx.core"))
    api(libs.org.reflections.reflections)
    testImplementation(libs.org.apache.httpcomponents.client5.httpclient5)
    testImplementation(libs.commons.io.commons.io)
}

description = "BaSyx Authorization Base"

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

configurations {
    create("testArtifacts") {
        extendsFrom(configurations["testRuntimeClasspath"])
    }
}

artifacts {
    add("testArtifacts", testsJar)
}

publishing {
    publications {
        // Fügen Sie das testsJar zu der bestehenden Maven-Publikation hinzu
        named<MavenPublication>("maven") {
            artifact(testsJar.get())
        }
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}
