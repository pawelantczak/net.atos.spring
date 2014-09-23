package net.atos.spring.guestbook;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by a516438 on 2014-09-23.
 */
@NodeEntity
public class Author {
    @GraphId Long id;
    @Indexed(unique=true)
    String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }
}
