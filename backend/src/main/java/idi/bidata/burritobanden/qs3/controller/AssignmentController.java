package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import idi.bidata.burritobanden.qs3.person.assignment.AssignmentService;
import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class AssignmentController {

    Logger logger = LoggerFactory.getLogger("LOGGER");

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



    // Delete operation
    @DeleteMapping("/assignments/{id}")
    public String deleteAssignmentById(@PathVariable("id")
                                             Long assignmentId)
    {
        assignmentService.deleteAssignmentById(
                assignmentId);
        return "Deleted Successfully";
    }

    @PostMapping("/assignments/{personId}/{subjectCode}")
    public Assignment giveStudentAssignments(@PathVariable("personId") Long personId,
                                             @PathVariable("subjectCode") String subjectCode) {
        return assignmentService.giveStudentAssignments(personId, subjectCode);
    }

    @PostMapping("/assignments/{personId}/{subjectCode}/{assignmentNumber}")
    public Assignment approveAssignment(@PathVariable("personId") Long personId,
                                        @PathVariable("subjectCode") String subjectCode,
                                        @PathVariable("assignmentNumber") int assignmentNumber) {
        return assignmentService.approveAssignment(personId, subjectCode, assignmentNumber);
    }
}
