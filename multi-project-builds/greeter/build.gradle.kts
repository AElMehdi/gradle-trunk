plugins {
    java        
    application 
}

application {
    mainClassName = "greeter.Greeter" 
}

dependencies {
    compile(project(":greeting-library")) 
}
