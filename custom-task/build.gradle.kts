open class Greeting : DefaultTask() {
    lateinit var message: String
    lateinit var recipient: String

    @TaskAction
    fun sayHello() {
        println("$message, $recipient!")
    }
}

tasks.register<Greeting>("ArabicHala") {
    group = "Welcome"
    description = "Says Hala"

    message = "Hala"
    recipient = "Badr"
}


tasks.register<Greeting>("JapaneseKonnichiha") {
    group = "Welcome"
    description = "Says chiwasu"

    message = "Konnichiha"
    recipient = "Keisuku"
}