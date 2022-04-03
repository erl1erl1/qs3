package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.model.authentication.AuthenticationRequest;
import idi.bidata.burritobanden.qs3.service.person.PersonService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PersonController {

    @Autowired private PersonService personService;
    Logger logger = LoggerFactory.getLogger(PersonController.class);

    // Create operation
    @PostMapping("/persons/register")
    public Person saveUser(
            @Valid @RequestBody Person person)
    {
        logger.info("New request: " + person);
        return personService.createPerson(person);
    }

    @PostMapping("persons/login")
    public Person getUser(@RequestBody AuthenticationRequest req){
        Person person = personService.findPersonByUsername(req.getUsername());
        if (req.getUsername().equals(person.getUsername()) && req.getUsername().equals(person.getPassword())){
            return person;
        }
        return null;
    }

    // Read operation
    @GetMapping("/persons")
    public List<Person> fetchPersonList()
    {
        logger.info("Size: " + personService.fetchPersonList().size());
        return personService.fetchPersonList();
    }

    @GetMapping("/persons/{id}/name")
    public String getName(@PathVariable Long id){
        Person person = personService.findPersonById(id);
        return person.getName();
    }


    // Update operation
    @PutMapping("/persons/{id}")
    public Person
    updateUser(@RequestBody Person person,
               @PathVariable("id") Long personId)
    {
        return personService.updatePerson(
                person, personId);
    }

    // Delete operation
    @DeleteMapping("/persons/{id}")
    public String deletePersonById(@PathVariable("id")
                                         Long personId)
    {
        personService.deletePersonById(
                personId);
        return "Deleted Successfully";
    }

    @GetMapping("/persons/{username}")
    public Long getUserId(@PathVariable String username) {
            Person req = personService.findPersonByUsername(username);
            return req.getPersonId();
    }
}
