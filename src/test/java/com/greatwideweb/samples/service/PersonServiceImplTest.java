package com.greatwideweb.samples.service;

import com.greatwideweb.samples.Application;
import com.greatwideweb.samples.vo.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Dave on 2/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;
    private String duplicateLastName ="Smith";
    private String newLastName ="Turner";

    @Before
    public void setup() {
        personService.truncatePeople();
        loadPeople();
    }

    @Test
    public void ensureSaveWorksAsExpected() {
        assertEquals(personService.getAllPeople().size(), 5);
    }

    @Test
    public void ensureGetPersonReturnsExpected() {
        Person p = personService.getAllPeople().get(1);
        System.out.println(p);
        assertEquals(p.getFirstName(), "Diana");
        assertEquals(p.getLastName(), "Geralt");
    }

    @Test
    public void ensureUpdateWorksAsExpected() {
        Person p = personService.getAllPeople().get(1);
        assertEquals(p.getFirstName(), personService.getAllPeople().get(1).getFirstName());
        assertEquals(p.getLastName(), personService.getAllPeople().get(1).getLastName());
        assertNotEquals(p.getLastName(), newLastName);
        p.setLastName(newLastName);
        personService.savePeson(p);
        p = personService.getAllPeople().get(1);
        assertEquals(p.getLastName(), newLastName);
    }

    @Test
    public void ensureFindByLastNameWorksAsExpected() {
        List<Person> list = personService.findPesonByLastName(duplicateLastName);
        assertEquals(list.size(), 2);
    }

    private void loadPeople() {
        personService.savePeson(new Person("Mack", duplicateLastName));
        personService.savePeson(new Person("Diana", "Geralt"));
        personService.savePeson(new Person("Kim", duplicateLastName));
        personService.savePeson(new Person("Ben", "Wallace"));
        personService.savePeson(new Person("Chauncey", "Billups"));
    }



}
