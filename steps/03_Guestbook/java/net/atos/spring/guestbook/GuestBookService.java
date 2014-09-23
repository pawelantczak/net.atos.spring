package net.atos.spring.guestbook;

import net.atos.spring.guestbook.entities.Entry;

import java.util.List;

public interface GuestBookService {

    Entry save(Entry guestBookEntity);

    List<Entry> findAll();

    List<Entry> findAllByAuthor(String author);
}
