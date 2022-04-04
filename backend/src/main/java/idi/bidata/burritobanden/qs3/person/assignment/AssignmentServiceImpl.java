package idi.bidata.burritobanden.qs3.person.assignment;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import idi.bidata.burritobanden.qs3.entity.Subject;
import idi.bidata.burritobanden.qs3.model.compositeKeys.AssignmentKey;
import idi.bidata.burritobanden.qs3.person.subject.SubjectService;
import idi.bidata.burritobanden.qs3.repository.AssignmentRepository;

import java.util.ArrayList;
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

    Logger logger = LoggerFactory.getLogger("LOGGER");

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    SubjectService subjectService;


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


    // Deletes an assignment by ID.
    @Override
    public void deleteAssignmentById(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    /*
    Gives a student assignments based on how many assignments the subject has.
     */
    @Override
    public Assignment giveStudentAssignments(Long personId, String subjectCode) {
        Subject subject = subjectService.findSubjectByCode(subjectCode);

        List<Boolean> assignments = new ArrayList<>();

        for(int i = 0; i < subject.getAssignments(); i++){
            assignments.add(false);
        }

        Assignment assignment = new Assignment(personId, subjectCode, assignments);

        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment approveAssignment(Long personId, String subjectCode, int assignmentNumber) {

        Assignment asDB = assignmentRepository.findAssignmentByPersonIdAndSubjectCode(personId, subjectCode);

        try{
            List<Boolean> listDB = asDB.getAssignments();
            listDB.set(assignmentNumber-1, true);

            asDB.setAssignments(listDB);

            assignmentRepository.save(asDB);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return asDB;
    }
}
