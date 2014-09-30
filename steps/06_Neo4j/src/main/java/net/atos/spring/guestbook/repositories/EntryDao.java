package net.atos.spring.guestbook.repositories;

import net.atos.spring.guestbook.entities.Author;
import net.atos.spring.guestbook.entities.Entry;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface EntryDao extends GraphRepository<Entry> {

    List<Entry> findAllByAuthor(Author author);


}
