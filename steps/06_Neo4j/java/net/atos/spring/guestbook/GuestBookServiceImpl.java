package net.atos.spring.guestbook;

import net.atos.spring.guestbook.entities.Entry;
import net.atos.spring.guestbook.repositories.AuthorDao;
import net.atos.spring.guestbook.repositories.EntryDao;
import net.atos.spring.guestbook.services.GuestBookService;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
        return IteratorUtil.asList(entriesRepository.findAll());
    }

    @Override public List<Entry> findAllEntriesByAuthor(String name) {
        return IteratorUtil
            .asList(entriesRepository.findAllByAuthor(authorRepository.findByName(name)));
    }

}
