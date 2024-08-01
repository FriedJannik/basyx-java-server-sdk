plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    testImplementation(project(path = ":basyx.aasdiscoveryservice-http"))
    testImplementation(project(path = ":basyx.aasdiscoveryservice-core"))
    testImplementation(project(path = ":basyx.aasdiscoveryservice-http", configuration = "testArtifacts"))
    testImplementation(project(path = ":basyx.aasdiscoveryservice-core", configuration = "testArtifacts"))
    testImplementation(project(path = ":basyx.http", configuration = "testArtifacts"))
    testImplementation(libs.org.apache.httpcomponents.client5.httpclient5)
    testImplementation(libs.commons.io.commons.io)
    testImplementation(libs.com.google.code.gson.gson)
}

description = "AAS Discovery Service TCK"

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

configurations {
    create("testArtifacts") {
        extendsFrom(configurations.testRuntimeClasspath.get())
    }
}

artifacts {
    add("testArtifacts", testsJar)
}

(publishing.publications["maven"] as MavenPublication).artifact(testsJar)

java {
    withJavadocJar()
}
// Disable the test task
tasks.named<Test>("test") {
    enabled = false
}