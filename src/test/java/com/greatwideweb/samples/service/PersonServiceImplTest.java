package com.greatwideweb.samples.service;

import com.greatwideweb.samples.vo.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dave on 2/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceImplTest {

    @Autowired
    private PersonServiceImpl service;


    @Before
    public void setup() {

    }

    @Test
    public void ensureSaveWorksAsExpected() {
        service.savePeson(new Person("Jack", "Bauer"));
        service.savePeson(new Person("Chloe", "O'Brian"));
        service.savePeson(new Person("Kim", "Bauer"));
        service.savePeson(new Person("David", "Palmer"));
        service.savePeson(new Person("Michelle", "Dessler"));
        assertEquals(service.getAllPeople().size(), 5);


    }

}
