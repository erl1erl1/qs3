package idi.bidata.burritobanden.qs3.controller;

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

    // Save operation
    @PostMapping("/subjects")
    public Subject saveSubject(
            @Valid @RequestBody Subject subject)
    {
        return subjectService.saveSubject(subject);
    }

    // Read operation
    @GetMapping("/subjects")
    public List<Subject> fetchSubjectList()
    {
        return subjectService.fetchSubjectList();
    }


    // Update operation
    @PutMapping("/subjects/{id}")
    public Subject
    updateUser(@RequestBody Subject subject,
               @PathVariable("id") Long subjectId)
    {
        return subjectService.updateSubject(
                subject, subjectId);
    }

    // Delete operation
    @DeleteMapping("/subjects/{id}")
    public String deleteUserById(@PathVariable("id")
                                         Long subjectId)
    {
        subjectService.deleteSubjectById(
                subjectId);
        return "Deleted Successfully";
    }
}
