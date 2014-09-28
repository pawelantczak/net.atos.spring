package net.atos.spring.guestbook.services;

import net.atos.spring.guestbook.entities.Entry;

import java.util.List;

public interface GuestBookService {

    Entry saveEntry(Entry guestBookEntity);

    List<Entry> findAllEntries();

    List<Entry> findAllEntriesByAuthor(String name);

    List<Entry> findAllEntriesOrderByAuthor();
}
