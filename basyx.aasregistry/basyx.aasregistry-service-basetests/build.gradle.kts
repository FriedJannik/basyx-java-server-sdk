plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    api(project(":basyx.aasregistry-paths"))
    api(project(":basyx.aasregistry-client-native"))
    api(project(":basyx.aasregistry-service"))
    api(libs.org.springframework.boot.spring.boot.starter.test)
    api(project(":basyx.authorization"))
    api(project(":basyx.http"))
    testImplementation(project(path = ":basyx.authorization", configuration = "testArtifacts"))
    testImplementation(project(path = ":basyx.http", configuration = "testArtifacts"))
    api(project(path = ":basyx.authorization", configuration = "testArtifacts"))
    api(project(path = ":basyx.http", configuration = "testArtifacts"))
    api(libs.org.apache.httpcomponents.client5.httpclient5)
    api(libs.org.junit.vintage.junit.vintage.engine)
    compileOnly(libs.org.projectlombok.lombok)
    compileOnly(project(":basyx.aasregistry-service-basemodel"))
    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")
}

description = "BaSyx AAS Registry Service Basetests"

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
