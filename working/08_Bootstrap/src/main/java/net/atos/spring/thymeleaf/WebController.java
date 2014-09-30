package net.atos.spring.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("h1", "Atos");
        model.addAttribute("p", "Spring Demo App");

        return "index";
    }
}
