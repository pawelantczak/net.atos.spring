package net.atos.spring.guestbook.services;

import net.atos.spring.guestbook.entities.Entry;
import net.atos.spring.guestbook.repositories.AuthorDao;
import net.atos.spring.guestbook.repositories.EntryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    EntryDao entriesRepository;

    @Autowired
    AuthorDao authorRepository;

    @Override public Entry saveEntry(Entry guestBookEntity) {
        return entriesRepository.save(guestBookEntity);
    }

    @Override public List<Entry> findAllEntries() {
        return entriesRepository.findAll();
    }

    @Override public List<Entry> findAllEntriesByAuthor(String name) {
        return entriesRepository.findAllByAuthor(authorRepository.findByName(name));
    }

    @Override
    public List<Entry> findAllEntriesOrderByAuthor() {
        return entriesRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "author.name")));
    }
}
