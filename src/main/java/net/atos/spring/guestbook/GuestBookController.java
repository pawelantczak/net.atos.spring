package net.atos.spring.guestbook;

import net.atos.spring.guestbook.entities.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    GuestBookService guestBookService;

    @RequestMapping(value = "/guestbook/getall", method = RequestMethod.GET)
    public List<Entry> getAll() {
        return guestBookService.findAll();
    }

    @RequestMapping(value = "/guestbook/author/{author}", method = RequestMethod.GET)
    public List<Entry> getAllByAuthor(@PathVariable String author) {
        return guestBookService.findAllByAuthor(author);
    }

    @RequestMapping(value = "/guestbook/add", method = RequestMethod.POST)
    public Entry add(@RequestParam String author,
        @RequestParam String content) {
        return guestBookService.save(new Entry(author, content));
    }


}
