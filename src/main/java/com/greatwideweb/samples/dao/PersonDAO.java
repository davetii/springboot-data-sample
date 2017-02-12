package com.greatwideweb.samples.dao;

import com.greatwideweb.samples.vo.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dave on 2/11/2017.
 */
public interface PersonDAO extends CrudRepository<Person, Long> {
    List<Person> findByLastName(String lastName);
}
