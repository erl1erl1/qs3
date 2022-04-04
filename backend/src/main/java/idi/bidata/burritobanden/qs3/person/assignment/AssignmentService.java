package idi.bidata.burritobanden.qs3.person.assignment;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import java.util.List;

/**
 * Service interface for Assignment.
 */
public interface AssignmentService {
    // Save operation
    Assignment saveAssignment(Assignment assignment);

    // Read operation
    List<Assignment> fetchAssignmentList();

    // Delete operation
    void deleteAssignmentById(Long assignmentId);


    // Gives a student assignments.
    Assignment giveStudentAssignments(Long personId, String subjectCode);
}
