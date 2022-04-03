package idi.bidata.burritobanden.qs3.service.subject;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.entity.Subject;
import idi.bidata.burritobanden.qs3.repository.SubjectRepository;
import idi.bidata.burritobanden.qs3.service.person.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    PersonService personService;

    Logger logger = LoggerFactory.getLogger("LOGGER");

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> fetchSubjectList() {
        return subjectRepository.findAll();
    }

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

    @Override
    public Subject findSubjectByCode(String subjectCode) {
        return subjectRepository.findBySubjectCode(subjectCode);
    }

    @Override
    public Person findPersonById(Long personId) {
        return personService.findPersonById(personId);
    }

    @Override
    public Person findPersonByUsername(String username) {
        return personService.findPersonByUsername(username);
    }

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

    @Override
    public void deleteSubjectByCode(String subjectCode) {
        subjectRepository.delete(subjectRepository.findBySubjectCode(subjectCode));
    }
}
