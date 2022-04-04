package idi.bidata.burritobanden.qs3.person.person;

import idi.bidata.burritobanden.qs3.entity.Person;
import java.util.List;

/**
 * Service interface for Person.
 */
public interface PersonService {
    Person createPerson(Person person);

    Person findPersonById(Long personId);

    Person findPersonByUsername(String username);

    Boolean authenticate(String username, String password);

    List<Person> fetchPersonList();

    Person updatePerson(Person person);

    void deletePersonById(Long personId);

    Person updatePersonByUsername(String username, String role);
}
