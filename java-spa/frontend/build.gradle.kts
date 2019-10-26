import com.moowork.gradle.node.npm.NpmTask

plugins {
  id("base")
  id("com.github.node-gradle.node") version "2.1.1"
}

repositories {
  mavenLocal()
  mavenCentral()
}

node {
  version = "10.15.0" // Bug: It constructs bin node file name based on the system arch info (e.g x86.tar.gz) which is not found in the dist server
  download = false
}

task<NpmTask>("npm-install"){
  inputs.dir("src")
  inputs.file("package.json")
  inputs.file("package-lock.json")

  setArgs(listOf("install"))
}

task<NpmTask>("ng-build") {
  dependsOn("npm-install")

  setArgs(listOf("run-script", "build"))
}

task<NpmTask>("ng-test") {
  dependsOn("assemble")
  setArgs(listOf("run-script", "test"))
}

task<NpmTask>("ng-lint") {
  dependsOn("ng-build")
  setArgs(listOf("run-script", "lint"))
}

tasks.assemble{
  dependsOn("ng-lint")
}

