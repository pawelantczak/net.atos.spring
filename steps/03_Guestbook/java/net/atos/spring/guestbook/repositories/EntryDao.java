package net.atos.spring.guestbook.repositories;

import net.atos.spring.guestbook.entities.Author;
import net.atos.spring.guestbook.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryDao extends JpaRepository<Entry, Long> {

    List<Entry> findAllByAuthor(Author author);


}
