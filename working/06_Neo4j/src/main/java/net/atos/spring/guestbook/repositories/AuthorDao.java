package net.atos.spring.guestbook.repositories;

import net.atos.spring.guestbook.entities.Author;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface AuthorDao extends GraphRepository<Author> {

    Author findByName(String name);


}
