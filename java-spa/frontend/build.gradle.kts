import com.moowork.gradle.node.npm.NpmTask

plugins {
  base
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

  val ngBuild = register<NpmTask>("ng-build") {
    dependsOn(npmCi)

    setArgs(listOf("run-script", "build"))
  }


  val ngLint = register<NpmTask>("ng-lint") {
    setArgs(listOf("run-script", "lint"))
  }

  val ngTest = register<NpmTask>("ng-test") {
    setArgs(listOf("run-script", "test"))
  }

  check {
    dependsOn(ngLint)
//    dependsOn(ngTest)
  }

  jar {
    from("dist/frontend")
    into("static")
  }

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

