package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.entity.Subject;
import idi.bidata.burritobanden.qs3.service.subject.SubjectService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class SubjectController {

    Logger logger = LoggerFactory.getLogger("LOGGER");

    @Autowired private SubjectService subjectService;

    // Create operation
    @PostMapping("/subjects")
    public Subject createSubject(
            @Valid @RequestBody Subject subject)
    {
        return subjectService.createSubject(subject);
    }

    @GetMapping("/subjects/{subjectCode}")
    public Subject getSubject(@PathVariable String subjectCode){
        return subjectService.findSubjectByCode(subjectCode);
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

    @PutMapping("/{username}/{role}/{subjectCode}")
    public Subject enrollPersonId(
            @PathVariable String username,
            @PathVariable String role,
            @PathVariable String subjectCode
    ) {
        return subjectService.enrollPersonId(username, role, subjectCode);
    }

    @DeleteMapping("/{subjectCode}")
    public String deleteSubject(
            @PathVariable String subjectCode
    ) {
        try {
            subjectService.deleteSubjectByCode(subjectCode);
            return "DELETE_SUCCESSFUL";
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return null;
    }
}
