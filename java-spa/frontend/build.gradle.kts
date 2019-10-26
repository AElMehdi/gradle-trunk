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
  version = "10.15.0"
  download = false
}

task<NpmTask>("ng-build"){
  inputs.dir("src")
  inputs.file("package.json")
  inputs.file("package-lock.json")

  setArgs(listOf("run-script", "build", "--", "--output-path=build"))
}
tasks.getByName("assemble").dependsOn("ng-build")
