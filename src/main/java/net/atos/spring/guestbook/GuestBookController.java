package net.atos.spring.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    GuestBookService guestBookService;

    @RequestMapping(value = "/guestbook/getall", method = RequestMethod.GET)
    public List<GuestBookEntity> getAll() {
        return guestBookService.findAll();
    }

    @RequestMapping(value = "/guestbook/author/{author}", method = RequestMethod.GET)
    public List<GuestBookEntity> getAllByAuthor(@PathVariable String author) {
        return guestBookService.findAllByAuthor(author);
    }

    @RequestMapping(value = "/guestbook/add", method = RequestMethod.POST)
    public GuestBookEntity add(@RequestParam String author,
        @RequestParam String content) {
        return guestBookService.save(new GuestBookEntity(author, content));
    }


}
