package net.atos.spring.guestbook.repositories;

import net.atos.spring.guestbook.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {

    Author findByName(String name);


}
