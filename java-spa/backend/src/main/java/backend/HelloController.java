package backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class HelloController {


    @GetMapping(path = "/hello")
    public String helloGradle() {
        return "Hello Gradle!";
    }
}