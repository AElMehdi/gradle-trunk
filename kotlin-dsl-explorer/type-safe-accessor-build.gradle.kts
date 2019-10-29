plugins {
    `java-library`
}

dependencies {
    implementation("junit:junit:4.12")
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    test {
        testLogging.showExceptions = true
    }
}



//Understanding when type-safe model accessors are available
//The Kotlin DSL currently supports type-safe model accessors for any of the following that are contributed by plugins:

//Dependency and artifact configurations (such as implementation and runtimeOnly contributed by the Java Plugin)
//
//Project extensions and conventions (such as sourceSets)

//Elements in the tasks and configurations containers

//Elements in project-extension containers (for example the source sets contributed by the Java Plugin that are added to the sourceSets container)

//Extensions on each of the above

//
//N.B: Only the main project build scripts and precompiled project script plugins have type-safe model accessors. Initialization scripts, settings scripts, script plugins do not. These limitations will be removed in a future Gradle release.
