plugins {
    `maven-publish`
    java
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation("com.itextpdf:itextpdf:5.5.13.1")

    implementation("org.apache.pdfbox:pdfbox:2.0.19")
    implementation("org.apache.pdfbox:fontbox:2.0.19")

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
