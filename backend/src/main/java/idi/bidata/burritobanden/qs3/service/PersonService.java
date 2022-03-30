package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);

    List<Person> fetchPersonList();

    Person updatePerson(Person person, Long personId);

    void deletePersonById(Long personId);
}
