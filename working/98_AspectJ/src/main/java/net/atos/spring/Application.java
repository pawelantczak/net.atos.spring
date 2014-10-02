package net.atos.spring;

import net.atos.spring.greetings.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {

    @Autowired
    Greetings greetings;

    @PostConstruct
    public void startup() {
        greetings.sayHello("Atos");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
