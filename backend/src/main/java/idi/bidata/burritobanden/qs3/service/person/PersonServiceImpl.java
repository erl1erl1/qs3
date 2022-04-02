package idi.bidata.burritobanden.qs3.service.person;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    Logger logger = LoggerFactory.getLogger("LOGGER");

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findPersonById(Long personId) {
        Person person = null;
        try {
            person = personRepository.getById(personId);
        } catch (Exception e){
            logger.info(e.toString());
        }
        return person;
    }

    @Override
    public Person findPersonByUsername(String username) {
        return personRepository.getByUsername(username);
    }

    @Override
    public Boolean authenticate(String username, String password) {
        Person person = null;
        try{
            person = personRepository.getByUsername(username);
            if(person.getUsername().equals(username) && person.getPassword().equals(password)){
                return true;
            }
        } catch (Exception e){
            logger.info(e.toString());
        }
        return false;
    }


    @Override
    public List<Person> fetchPersonList() {
        return personRepository.findAll();
    }

    @Override
    public Person updatePerson(Person person, Long personId) {
        Person _person = personRepository.getById(personId);
        try{
            _person.setName(person.getName());
            _person.setRole(person.getRole());
        } catch (Exception e){
            logger.info(e.toString());
        }
        return personRepository.save(_person);
    }

    @Override
    public void deletePersonById(Long personId) {
        try{
            personRepository.delete(personRepository.getById(personId));
        } catch (Exception e){
            logger.info(e.toString());
        }

    }
}
