package net.atos.spring.greetings;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GreetingsImpl implements Greetings {

    private Logger log = Logger.getLogger(GreetingsImpl.class);

    private static final String template = "Hello, %s!";

    @Override public void sayHello(String name) {
        log.info(String.format(template, name));
    }
}
