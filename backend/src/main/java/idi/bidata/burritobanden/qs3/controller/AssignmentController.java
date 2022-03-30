package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import idi.bidata.burritobanden.qs3.service.AssignmentService;
import java.util.List;
// Importing required classes
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class AssignmentController {

    @Autowired private AssignmentService assignmentService;

    // Save operation
    @PostMapping("/assignments")
    public Assignment saveAssignment(
            @Valid @RequestBody Assignment assignment)
    {
        return assignmentService.saveAssignment(assignment);
    }

    // Read operation
    @GetMapping("/assignments")
    public List<Assignment> fetchAssignmentList()
    {
        return assignmentService.fetchAssignmentList();
    }


    // Update operation
    @PutMapping("/assignments/{id}")
    public Assignment
    updateUser(@RequestBody Assignment assignment,
               @PathVariable("id") Long assignmentId)
    {
        return assignmentService.updateAssignment(
                assignment, assignmentId);
    }

    // Delete operation
    @DeleteMapping("/assignments/{id}")
    public String deleteAssignmentById(@PathVariable("id")
                                             Long assignmentId)
    {
        assignmentService.deleteAssignmentById(
                assignmentId);
        return "Deleted Successfully";
    }

}
