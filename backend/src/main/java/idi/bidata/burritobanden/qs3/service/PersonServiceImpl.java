package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findPersonById(Long personId) {
        return personRepository.getById(personId);
    }


    @Override
    public List<Person> fetchPersonList() {
        return null;
    }

    @Override
    public Person updatePerson(Person person, Long personId) {
        return null;
    }

    @Override
    public void deletePersonById(Long personId) {

    }
}
