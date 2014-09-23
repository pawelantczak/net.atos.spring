package net.atos.spring.guestbook;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestBookServiceImpl implements GuestBookService {

    @Autowired
    GuestBookDao repository;

    @Override public GuestBookEntity save(GuestBookEntity guestBookEntity) {
        return repository.save(guestBookEntity);
    }

    @Override public List<GuestBookEntity> findAll() {
        return IteratorUtil.asList(repository.findAll());
    }

    @Override public List<GuestBookEntity> findAllByAuthor(String author) {
        return IteratorUtil.asList(repository.findAll());
    }
}
