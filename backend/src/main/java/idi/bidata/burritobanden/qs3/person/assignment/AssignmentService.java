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
    // Update operation
    Assignment updateAssignment(Assignment assignment, Long assignmentId);
    // Delete operation
    void deleteAssignmentById(Long assignmentId);
}
