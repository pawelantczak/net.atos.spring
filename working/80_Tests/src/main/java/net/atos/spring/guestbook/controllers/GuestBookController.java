package net.atos.spring.guestbook.controllers;

import net.atos.spring.guestbook.entities.Entry;
import net.atos.spring.guestbook.services.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestBookController {

    @Autowired
    GuestBookService guestBookService;

    @RequestMapping(value = "/guestbook/getall", method = RequestMethod.GET)
    public List<Entry> getAll() {
        return guestBookService.findAllEntries();
    }

    @RequestMapping(value = "/guestbook/author/{author}", method = RequestMethod.GET)
    public List<Entry> getAllByAuthor(@PathVariable String author) {
        return guestBookService.findAllEntriesByAuthor(author);
    }

    @RequestMapping(value = "/guestbook/add", method = RequestMethod.POST)
    public Entry add(@RequestParam String author,
        @RequestParam String content) {
        return guestBookService.saveEntry(new Entry(author, content));
    }


}
