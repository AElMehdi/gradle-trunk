import com.moowork.gradle.node.npm.NpmTask

plugins {
  java
  id("com.moowork.node") version "1.3.1"
}

repositories {
  mavenLocal()
  mavenCentral()
}

node {
  version = "10.15.0" // Bug: It constructs bin node file name based on the system arch info (e.g x86.tar.gz) which is not found in the dist server
  download = false
}

tasks {

  val npmCi = register<NpmTask>("npm-ci") {
    inputs.dir("src")
    inputs.file("package.json")
    inputs.file("package-lock.json")

    setArgs(listOf("ci"))
  }



  val ngLint = register<NpmTask>("ng-lint") {
    setArgs(listOf("run-script", "lint"))
  }

  val ngTest = register<NpmTask>("ng-test") {
    setArgs(listOf("run-script", "test"))
  }

  val ngBuild = register<NpmTask>("ng-build") {
    dependsOn(npmCi)
    dependsOn(ngLint)
    dependsOn(ngTest)

    inputs.dir("src")
    inputs.file("package.json")
    inputs.file("package-lock.json")

    setArgs(listOf("run-script", "build"))
  }

  jar {
    dependsOn(ngBuild)

    from("dist")
  }

}
