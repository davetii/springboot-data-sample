package com.greatwideweb.samples;

import com.greatwideweb.samples.dao.PersonDAO;
import com.greatwideweb.samples.service.PersonService;
import com.greatwideweb.samples.vo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Created by Dave on 2/11/2017.
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(PersonService service) {

        return (args) -> {
            // save a couple of People
            service.savePeson(new Person("Jack", "Bauer"));
            service.savePeson(new Person("Chloe", "O'Brian"));
            service.savePeson(new Person("Kim", "Bauer"));
            service.savePeson(new Person("David", "Palmer"));
            service.savePeson(new Person("Michelle", "Dessler"));

            // fetch all People
            log.info("People found with findAll():");
            log.info("-------------------------------");
            for (Person p : service.getAllPeople()) {
                log.info(p.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Person p = service.getPerson(2L);
            log.info("Person at ID #2:");
            log.info("--------------------------------");
            log.info(p.toString());
            log.info("");

            // fetch person by last name
            log.info("Person findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Person bauer : service.findPesonByLastName("Bauer")) {
                log.info(bauer.toString());
            }



        };

    }

}
