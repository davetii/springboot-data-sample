package com.greatwideweb.samples.service;

import com.greatwideweb.samples.Application;
import com.greatwideweb.samples.vo.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        Person p = personService.getPerson(2l);
        assertEquals(p.getFirstName(), "Chloe");
        assertEquals(p.getLastName(), "O'Brian");
    }

    @Test
    public void ensureUpdateWorksAsExpected() {
        Person p = personService.getAllPeople().get(2);
        assertEquals(p.getFirstName(), personService.getAllPeople().get(2).getFirstName());
        assertEquals(p.getLastName(), personService.getAllPeople().get(2).getLastName());
        assertNotEquals(p.getLastName(), "Jones");
        p.setLastName("Jones");
        personService.savePeson(p);
        p = personService.getAllPeople().get(2);
        assertEquals(p.getLastName(), "Jones");
    }

    private void loadPeople() {
        personService.savePeson(new Person("Jack", "Bauer"));
        personService.savePeson(new Person("Chloe", "O'Brian"));
        personService.savePeson(new Person("Kim", "Bauer"));
        personService.savePeson(new Person("David", "Palmer"));
        personService.savePeson(new Person("Michelle", "Dessler"));
    }



}
