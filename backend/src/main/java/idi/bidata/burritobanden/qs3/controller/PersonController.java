package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.model.authentication.AuthenticationRequest;
import idi.bidata.burritobanden.qs3.service.person.PersonService;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    // Login request. Checks if authentication and login credentials checks out.
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

    // Get operation. Returns a persons name, based on the id.
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

    // Update person by username
    @PutMapping("persons/{username}/{role}")
    public Person updatePersonByUsername(@PathVariable("username") String username,
                                         @PathVariable("role") String role) {
        return personService.updatePersonByUsername(username, role);
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

    // Get operation. Returns the user id based on a persons username.
    @GetMapping("/persons/{username}")
    public Long getUserId(@PathVariable String username) {
            Person req = personService.findPersonByUsername(username);
            return req.getPersonId();
    }
}
