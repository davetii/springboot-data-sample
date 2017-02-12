package com.greatwideweb.samples.service;

import com.greatwideweb.samples.dao.PersonDAO;
import com.greatwideweb.samples.vo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Dave on 2/11/2017.
 */

public interface PersonService {
    List<Person> getAllPeople();
    Person getPerson(Long id);
    void savePeson(Person p);
    List<Person> findPesonByLastName(String lastName);
    void truncatePeople();
}
