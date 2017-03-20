package br.com.douglastuiuiu.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

/**
 * @author douglasg
 * @since 20/03/2017
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.douglastuiuiu")
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @PostConstruct
    public void testLog() {
        logger.debug("Welcome to MicroService Archetype!");
    }

    public static void main(String[] agrs) {
        SpringApplication.run(Application.class);
    }
}
