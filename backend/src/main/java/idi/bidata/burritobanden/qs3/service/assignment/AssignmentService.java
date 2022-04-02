package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Assignment;

import java.util.List;

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
