package net.atos.spring.guestbook;

import net.atos.spring.guestbook.entities.Entry;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface GuestBookDao extends GraphRepository<Entry> {

    //List<GuestBookEntity> findAllByAuthor(String author);

}
