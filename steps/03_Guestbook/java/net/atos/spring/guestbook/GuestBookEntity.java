package net.atos.spring.guestbook;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "guest_book")
public class GuestBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public int id;

    @Column
    public String author;

    @Column
    public String content;

    @Column(name = "insert_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date insertDate;

    public GuestBookEntity() {
    }

    public GuestBookEntity(String author, String content) {
        this.author = author;
        this.content = content;
    }

    @PrePersist
    protected void prePersist() {
        insertDate = new Date();
    }
}
