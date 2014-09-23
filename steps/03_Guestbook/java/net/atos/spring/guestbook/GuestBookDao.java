package net.atos.spring.guestbook;

import net.atos.spring.guestbook.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestBookDao extends JpaRepository<Entry, Long> {

    List<Entry> findAllByAuthor(String author);
}
