println("This is executed during configuration phase")

tasks.register("configured") {
    println("This is executed during configuration phase")
}

tasks.register("test") {
    doLast {
        println("This is executed during execution phase")
    }
}

tasks.register("testBoth") {
    doLast {
        println("This is executed last during execution phase")
    }
    doFirst {
        println("This is executed first during execution phase")
    }

    println("This is executed during configuration phase as well")
}