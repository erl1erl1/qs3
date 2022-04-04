package idi.bidata.burritobanden.qs3.person.subject;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.entity.Subject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Service interface for Subject.
 */
public interface SubjectService {
    Subject createSubject(Subject subject);

    Person findPersonById(Long personId);

    List<Subject> fetchSubjectList();

    Subject updateSubject(Subject subject, String subjectCode);

    Subject enrollStudent(String subjectCode, Long personId);

    Subject findSubjectByCode(String subjectCode);

    Person findPersonByUsername(String username);

    Subject enrollPersonId(String username, String role, String subjectCode );

    Subject addSubject(String subjectCode, String subjectName, int assignments, MultipartFile file);

    void deleteSubjectByCode(String subjectCode);
}
