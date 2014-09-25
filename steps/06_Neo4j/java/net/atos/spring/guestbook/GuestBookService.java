package net.atos.spring.guestbook;

import net.atos.spring.guestbook.entities.Entry;

import java.util.List;

public interface GuestBookService {

    Entry saveEntry(Entry guestBookEntity);

    List<Entry> findAllEntries();

    List<Entry> findAllEntriesByAuthor(String name);

}
