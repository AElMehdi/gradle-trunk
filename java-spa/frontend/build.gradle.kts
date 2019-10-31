import com.moowork.gradle.node.npm.NpmTask

plugins {
  id("base")
  id("java")
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

tasks.named("npmInstall") {
  inputs.dir("src")
  inputs.file("package.json")
  inputs.file("package-lock.json")
}

task<NpmTask>("ng-build") {
  dependsOn("npmInstall")

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


tasks.assemble {
  dependsOn("ng-lint")
}

tasks.jar {
  dependsOn("ng-lint")

  from("dist")
  into("static")
}

//
//task<NpmTask>("ng-run") {
//  setArgs(listOf("run-script", "start"))
//  shouldRunAfter(":assemble")
//}
////
////tasks.test {
////  dependsOn("ng-test")
////}

