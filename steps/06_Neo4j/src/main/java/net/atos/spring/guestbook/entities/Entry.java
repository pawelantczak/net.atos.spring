package net.atos.spring.guestbook.entities;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Date;

@NodeEntity
public class Entry {

    @GraphId
    private Long id;

    //@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "idAuthor")
    //@DBRef
    @Fetch
    @RelatedTo(type = "AUTHOR", direction = Direction.INCOMING)
    private Author author;

    private String content;

    private Date insertDate;

    public Entry() {
    }

    public Entry(String author, String content) {
        this.author = new Author(author);
        this.content = content;
        this.insertDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
