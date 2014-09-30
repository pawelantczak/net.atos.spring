package net.atos.spring.greetings;

import java.util.Date;

public class Greeting {
    private final long id;
    private final String content;
    private final Date date = new Date();

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
