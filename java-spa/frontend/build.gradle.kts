import com.moowork.gradle.node.npm.NpmTask

plugins {
  base
  java
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
tasks.npmInstall {
  inputs.dir("src")
  inputs.file("package.json")
  inputs.file("package-lock.json")
}

tasks.register("ng-build", NpmTask::class) {
  println("buil angular task")

  dependsOn("npmInstall")

  setArgs(listOf("run-script", "build"))
}

tasks.register("ng-test", NpmTask::class) {
  dependsOn("assemble")
  setArgs(listOf("run-script", "test"))
}

tasks.register("ng-lint", NpmTask::class) {
  println("linter task")

  dependsOn("ng-build")
  setArgs(listOf("run-script", "lint"))
}

tasks.jar {
  from("dist/frontend")
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

