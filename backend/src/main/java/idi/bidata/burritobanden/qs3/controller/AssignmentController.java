package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import idi.bidata.burritobanden.qs3.person.assignment.AssignmentService;
import java.util.List;
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

    @GetMapping("/assignments/update/{subjectCode}")
    public void updateAssignments(@PathVariable("subjectCode") String subjectCode){
        assignmentService.updateAssignments(subjectCode);
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

    /*
    Gives students assignments based on what subject.
     */
    @PostMapping("/assignments/{personId}/{subjectCode}")
    public Assignment giveStudentAssignments(@PathVariable("personId") Long personId,
                                             @PathVariable("subjectCode") String subjectCode) {
        return assignmentService.giveStudentAssignments(personId, subjectCode);
    }

    /*
    Used to approve students assignments.
     */
    @PostMapping("/assignments/{personId}/{subjectCode}/{assignmentNumber}")
    public Assignment approveAssignment(@PathVariable("personId") Long personId,
                                        @PathVariable("subjectCode") String subjectCode,
                                        @PathVariable("assignmentNumber") int assignmentNumber) {
        return assignmentService.approveAssignment(personId, subjectCode, assignmentNumber);
    }
}
