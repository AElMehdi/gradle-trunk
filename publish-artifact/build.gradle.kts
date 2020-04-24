plugins {
    `maven-publish`
    java
}

repositories {
    jcenter()
}

dependencies {
    implementation("com.itextpdf:itext7-core:7.0.4")
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
    jar {
        manifest {
            attributes(
                    mapOf("Implementation-Title" to project.name,
                            "Implementation-Version" to project.version)
            )
        }
    }
}
