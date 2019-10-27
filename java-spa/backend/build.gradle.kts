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
    // This dependency is used by the application.
    implementation("com.google.guava:guava:28.0-jre")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")

    implementation("org.springframework.boot:spring-boot-dependencies:2.0.5.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

//  Migrate to kotlin Later on
//    components {
//        withModule("org.springframework:spring-beans") {
//            constraints {
//                implementation("org.apache.httpcomponents:httpclient:4.5.3") {
//                    because("previous versions have a bug impacting this application")
//                }
//            allVariants {
//                withDependencyConstraints {
//                    // Need to patch constraints because snakeyaml is an optional dependency
//                    this.filter { name == "snakeyaml" }.forEach(action = )
//                }
//            }
//        }
//    }
}


application {
    mainClassName = "backend.App"
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

tasks.getByName<BootJar>("bootJar") {
    getArchiveClassifier()
}
