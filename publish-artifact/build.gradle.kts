plugins {
    `maven-publish`
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.aelmehdi"
            artifactId = "myArtifact"
            version = "1.0"

//            from(components["java"])
        }
    }
}
