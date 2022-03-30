package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.PersonSubject;
import idi.bidata.burritobanden.qs3.service.PersonSubjectService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PersonSubjectController {

    @Autowired private PersonSubjectService personSubjectService;

    // Save operation
    @PostMapping("/personSubjects")
    public PersonSubject savePersonSubject(
            @Valid @RequestBody PersonSubject personSubject)
    {
        return personSubjectService.savePersonSubject(personSubject);
    }

    // Read operation
    @GetMapping("/personSubjects")
    public List<PersonSubject> fetchPersonSubjectList()
    {
        return personSubjectService.fetchPersonSubjectList();
    }


    // Update operation
    @PutMapping("/personSubjects/{id}")
    public PersonSubject
    updateUser(@RequestBody PersonSubject personSubject,
               @PathVariable("id") Long personSubjectId)
    {
        return personSubjectService.updatePersonSubject(
                personSubject, personSubjectId);
    }

    // Delete operation
    @DeleteMapping("/personSubjects/{id}")
    public String deletePersonSubjectById(@PathVariable("id")
                                         Long personSubjectId)
    {
        personSubjectService.deletePersonSubjectById(
                personSubjectId);
        return "Deleted Successfully";
    }
}
