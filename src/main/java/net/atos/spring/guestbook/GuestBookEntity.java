package net.atos.spring.guestbook;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Date;

@NodeEntity
public class GuestBookEntity {

    @GraphId Long id;

    @RelatedTo(type="AUTHOR", direction = Direction.INCOMING)
    public Author author;

    public String content;

    public Date insertDate;

    public GuestBookEntity() {
    }

    public GuestBookEntity(String author, String content) {
        this.author = new Author(author);
        this.content = content;
        this.insertDate = new Date();
    }

}
