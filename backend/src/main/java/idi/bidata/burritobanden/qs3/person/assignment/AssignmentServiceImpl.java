package idi.bidata.burritobanden.qs3.person.assignment;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import idi.bidata.burritobanden.qs3.repository.AssignmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service implementation for Assignment. The service is used for business functionalities.
 * The @Service tag lets Spring context autodetect the class.
 */
@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    Logger logger = LoggerFactory.getLogger("LOGGER");


    // Creates an assignment.
    @Override
    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    // Fetches list of assignments.
    @Override
    public List<Assignment> fetchAssignmentList() {
        return (List<Assignment>)
                assignmentRepository.findAll();
    }

    // Updates an assignment by the assignment ID.
    @Override
    public Assignment updateAssignment(Assignment assignment, Long assignmentId) {

        Assignment assDB = assignmentRepository.findById(assignmentId).get();
        try{
            assDB.setPersonId(assignment.getPersonId());
            assDB.setSubjectId(assignment.getSubjectId());
            assDB.setAssignmentNum(assignment.getAssignmentNum());
        } catch (Exception e) {
            logger.info(e.toString());
        }

        return assignmentRepository.save(assDB);
    }

    // Deletes an assignment by ID.
    @Override
    public void deleteAssignmentById(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}
