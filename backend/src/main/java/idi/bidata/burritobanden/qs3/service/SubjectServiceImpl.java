package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.entity.Subject;
import idi.bidata.burritobanden.qs3.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    PersonService personService;

    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> fetchSubjectList() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject updateSubject(Subject subject, Long subjectId) {
        Subject _subject = subjectRepository.getById(subjectId);
        _subject.setSubjectName(subject.getSubjectName());
        _subject.setAssignments(subject.getAssignments());
        return subjectRepository.save(_subject);
    }

    @Override
    public Subject enrollStudent(Long subjectId, Long personId){
            Subject subject = subjectRepository.getById(subjectId);
            Person person = personService.findPersonById(personId);
            subject.enrollStudent(person);
            return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubjectById(Long subjectId) {

    }

    @Override
    public Subject findSubjectById(Long subjectId){
        if (subjectRepository.findById(subjectId).isPresent()){
            return subjectRepository.findById(subjectId).get();
        }
        return null;
    }

    @Override
    public Person findPersonById(Long personId) {
        return personService.findPersonById(personId);
    }
}
