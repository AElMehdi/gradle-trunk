import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    application

    id("org.springframework.boot") version "2.0.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    runtime(project(":frontend"))

    implementation("org.springframework.boot:spring-boot-dependencies:2.0.5.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")

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

sourceSets {
    main {
        resources {
            srcDirs("${rootProject.projectDir}/frontend/dist/")
        }
    }
}
