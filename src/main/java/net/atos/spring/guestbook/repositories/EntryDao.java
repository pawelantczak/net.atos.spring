package net.atos.spring.guestbook.repositories;

import net.atos.spring.guestbook.entities.Author;
import net.atos.spring.guestbook.entities.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntryDao extends MongoRepository<Entry, Long> {

    List<Entry> findAllByAuthor(Author author);


}
