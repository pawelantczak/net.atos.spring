package net.atos.spring.thymeleaf;

import net.atos.spring.guestbook.entities.Entry;
import net.atos.spring.guestbook.services.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    GuestBookService guestBookService;

    @RequestMapping(value = "/web/guestbook/author/{author}", method = RequestMethod.GET)
    public String getAllByAuthor(@PathVariable String author, Model model) {
        model.addAttribute("gb", guestBookService.findAllByAuthor(author));
        return "index";
    }

    @RequestMapping(value = "/web/guestbook/add", method = RequestMethod.POST)
    public String add(@RequestParam String author,
        @RequestParam String content, Model model) {
        guestBookService.save(new Entry(author, content));
        model.addAttribute("gb", guestBookService.findAll());
        return "index";
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("gb", guestBookService.findAll());
        return "index";
    }


}
