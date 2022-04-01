package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.model.authentication.AuthenticationRequest;
import idi.bidata.burritobanden.qs3.service.PersonService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PersonController {

    @Autowired private PersonService personService;

    // Create operation
    @PostMapping("/persons/register")
    public Person saveUser(
            @Valid @RequestBody Person person)
    {
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
        return personService.fetchPersonList();
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
}
