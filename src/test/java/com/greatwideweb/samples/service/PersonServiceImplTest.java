package com.greatwideweb.samples.service;

import com.greatwideweb.samples.Application;
import com.greatwideweb.samples.vo.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dave on 2/11/2017.
 */
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceImplTest {

    private PersonService personService;

    @Before
    public void setup() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
        personService = ctx. getBean("personServiceImpl", PersonServiceImpl.class);
    }

    @Test
    public void ensureSaveWorksAsExpected() {
        personService.savePeson(new Person("Jack", "Bauer"));
        personService.savePeson(new Person("Chloe", "O'Brian"));
        personService.savePeson(new Person("Kim", "Bauer"));
        personService.savePeson(new Person("David", "Palmer"));
        personService.savePeson(new Person("Michelle", "Dessler"));
        assertEquals(personService.getAllPeople().size(), 5);


    }

}
