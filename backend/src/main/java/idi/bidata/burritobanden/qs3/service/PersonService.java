package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);

    Person findPersonById(Long personId);

    Person findPersonByUsername(String username);

    Boolean authenticate(String username, String password);

    List<Person> fetchPersonList();

    Person updatePerson(Person person, Long personId);

    void deletePersonById(Long personId);
}
