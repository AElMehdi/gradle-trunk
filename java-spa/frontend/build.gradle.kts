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

  setArgs(listOf("run-script", "build", "--output-path=build"))
}

tasks.getByName("assemble").dependsOn("ng-build")
