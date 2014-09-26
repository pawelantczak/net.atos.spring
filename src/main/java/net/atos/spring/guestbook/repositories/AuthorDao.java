package net.atos.spring.guestbook.repositories;

import net.atos.spring.guestbook.entities.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorDao extends MongoRepository<Author, Long> {

    Author findByName(String name);


}
