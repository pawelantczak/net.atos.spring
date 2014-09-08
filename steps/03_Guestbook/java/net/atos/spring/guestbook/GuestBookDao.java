package net.atos.spring.guestbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestBookDao extends JpaRepository<GuestBookEntity, Long> {

    List<GuestBookEntity> findAllByAuthor(String author);
}
