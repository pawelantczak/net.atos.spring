package net.atos.spring.guestbook;

import net.atos.spring.guestbook.entities.Entry;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    GuestBookDao repository;

    @Override public Entry save(Entry guestBookEntity) {
        return repository.save(guestBookEntity);
    }

    @Override public List<Entry> findAll() {
        return IteratorUtil.asList(repository.findAll());
    }

    @Override public List<Entry> findAllByAuthor(String author) {
        return IteratorUtil.asList(repository.findAll());
    }
}
