package idi.bidata.burritobanden.qs3.person.subject;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.entity.Subject;
import idi.bidata.burritobanden.qs3.repository.SubjectRepository;
import idi.bidata.burritobanden.qs3.person.person.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service implementation for Subject. The service is used for business functionalities.
 * The @Service tag lets Spring context autodetect the class.
 */
@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    PersonService personService;

    Logger logger = LoggerFactory.getLogger("LOGGER");

    //Creates a subject.
    @Override
    public Subject createSubject(Subject subject) {
        Subject subject1 = new Subject();
        subject1.setSubjectCode(subject.getSubjectCode());
        subject1.setSubjectName(subject.getSubjectName());
        subject1.setAssignments(subject.getAssignments());
        return subjectRepository.save(subject1);
    }

    // Fetches list of subjects.
    @Override
    public List<Subject> fetchSubjectList() {
        return subjectRepository.findAll();
    }

    // Updates a subject by subject code.
    @Override
    public Subject updateSubject(Subject subject, String subjectCode) {
        Subject _subject = null;
        try{
            _subject = subjectRepository.findBySubjectCode(subjectCode);
            _subject.setSubjectName(subject.getSubjectName());
            _subject.setAssignments(subject.getAssignments());
            _subject = subjectRepository.save(_subject);
        } catch (Exception e){
            logger.info(e.toString());
        }
        return _subject;
    }

    // Adds a student entity to to a subject entity.
    @Override
    public Subject enrollStudent(String subjectCode, Long personId){
        Subject subject = null;
        Person person = null;
        try{
            subject = subjectRepository.findBySubjectCode(subjectCode);
            person = personService.findPersonById(personId);
            subject.enrollStudent(person);
            person.addSubject(subject);
            subject = subjectRepository.save(subject);
        } catch (Exception e){
            logger.info(e.toString());
        }
        return subject;
    }

    // Finds subject by subject code and returns the subject entity.
    @Override
    public Subject findSubjectByCode(String subjectCode) {
        return subjectRepository.findBySubjectCode(subjectCode);
    }

    //Finds person by ID and returns the person entity.
    @Override
    public Person findPersonById(Long personId) {
        return personService.findPersonById(personId);
    }

    //Finds person by username and returns the person entity.
    @Override
    public Person findPersonByUsername(String username) {
        return personService.findPersonByUsername(username);
    }

    // Adds person to subject entity by ID.
    @Override
    public Subject enrollPersonId(String username, String role, String subjectCode ) {
        Person person;
        Subject subject = null;
        try {
            person = findPersonByUsername(username);
            person.setRole(role);
            subject = subjectRepository.findBySubjectCode(subjectCode);
            subject.enrollPerson(person);
            person.addSubject(subject);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return subject;
    }

    // Deletes subject entity by its subject code.
    @Override
    public void deleteSubjectByCode(String subjectCode) {
        subjectRepository.delete(subjectRepository.findBySubjectCode(subjectCode));
    }
}
