plugins {
    `maven-publish`
    java
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("com.itextpdf:itext7-core:7.0.4")

    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
    testCompile("org.assertj:assertj-core:3.11.1")

}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.aelmehdi"
            artifactId = "myArtifact"
            version = "1.0"
            from(components["java"])
        }

    }
}

tasks {
    test {
        useJUnitPlatform()
    }
    jar {
        manifest {
            attributes(
                    mapOf("Implementation-Title" to project.name,
                            "Implementation-Version" to project.version)
            )
        }
    }
}
