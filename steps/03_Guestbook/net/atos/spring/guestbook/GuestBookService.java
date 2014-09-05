package net.atos.spring.guestbook;

import java.util.List;

public interface GuestBookService {

    GuestBookEntity save(GuestBookEntity guestBookEntity);

    List<GuestBookEntity> findAll();

    List<GuestBookEntity> findAllByAuthor(String author);
}
