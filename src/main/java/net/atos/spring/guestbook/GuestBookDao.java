package net.atos.spring.guestbook;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface GuestBookDao extends GraphRepository<GuestBookEntity> {

    //List<GuestBookEntity> findAllByAuthor(String author);

}
