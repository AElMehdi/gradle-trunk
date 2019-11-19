import org.example.greeting.Greeting

//apply<org.example.greeting.GreetingPlugin>()
plugins {
    id("org.example.greeting")
}
tasks.getByName<Greeting>("hello") {
    message = "Hi"
    recipient = "me"
}
