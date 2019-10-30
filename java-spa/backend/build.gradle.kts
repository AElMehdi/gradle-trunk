import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    application
    war

    id("org.springframework.boot") version "2.0.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":frontend"))

    // This dependency is used by the application.
    implementation("com.google.guava:guava:28.0-jre")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")

    implementation("org.springframework.boot:spring-boot-dependencies:2.0.5.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


application {
    mainClassName = "backend.App"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

tasks.getByName<BootJar>("bootJar") {
    mainClassName = "backend.App"
}

val webappDir = "${rootProject.projectDir}/frontend/dist"

sourceSets {
    main {
        resources {
            srcDirs("$webappDir")
        }
    }
}
