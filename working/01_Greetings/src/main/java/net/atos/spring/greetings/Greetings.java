package net.atos.spring.greetings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Greetings {

    private static final String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public @ResponseBody String greeting(
        @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return String.format(template, name);
    }
}
