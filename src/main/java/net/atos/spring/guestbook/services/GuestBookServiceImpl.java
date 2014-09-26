package net.atos.spring.guestbook.services;

import net.atos.spring.guestbook.entities.Author;
import net.atos.spring.guestbook.entities.Entry;
import net.atos.spring.guestbook.repositories.AuthorDao;
import net.atos.spring.guestbook.repositories.EntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    EntryDao entriesRepository;

    @Autowired
    AuthorDao authorRepository;

    @Override public Entry saveEntry(Entry entry) {
        Author author = authorRepository.findByName(entry.getAuthor().getName());
        if (author == null) {
            entry.setAuthor(authorRepository.save(entry.getAuthor()));
        } else {
            entry.setAuthor(author);
        }

        return entriesRepository.save(entry);
    }

    @Override public List<Entry> findAllEntries() {
        return entriesRepository.findAll();
    }

    @Override public List<Entry> findAllEntriesByAuthor(String name) {
        return entriesRepository.findAllByAuthor(authorRepository.findByName(name));
    }

}
