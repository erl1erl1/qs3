package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.entity.Subject;
import idi.bidata.burritobanden.qs3.service.SubjectService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class SubjectController {

    @Autowired private SubjectService subjectService;

    // Create operation
    @PostMapping("/subjects")
    public Subject createSubject(
            @Valid @RequestBody Subject subject)
    {
        return subjectService.createSubject(subject);
    }

    // Read operation
    @GetMapping("/subjects")
    public List<Subject> fetchSubjectList()
    {
        return subjectService.fetchSubjectList();
    }

    @PutMapping("/{subjectCode}/students/{personId}")
    public Subject enrollStudent(
            @PathVariable String subjectCode,
            @PathVariable Long personId
    ) {
        Subject subject = subjectService.findSubjectByCode(subjectCode);
        Person person = subjectService.findPersonById(personId);
        subject.enrollStudent(person);
        return subjectService.enrollStudent(subjectCode, personId);
    }
}
