package com.greatwideweb.samples.service;

import com.greatwideweb.samples.dao.PersonDAO;
import com.greatwideweb.samples.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dave on 2/11/2017.
 */
@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO dao;

    @Override
    public List<Person> getAllPeople() {
        return (List<Person>) dao.findAll();
    }

    @Override
    public Person getPerson(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void savePeson(Person p) {
        dao.save(p);
    }

    @Override
    public List<Person> findPesonByLastName(String lastName) {
        return dao.findByLastName(lastName);
    }

    @Override
    public void truncatePeople() { dao.deleteAll(); }
}
