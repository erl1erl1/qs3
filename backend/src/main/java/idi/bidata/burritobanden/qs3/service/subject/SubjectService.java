package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.entity.Subject;
import org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SubjectService {
    Subject createSubject(Subject subject);

    Person findPersonById(Long personId);

    List<Subject> fetchSubjectList();

    Subject updateSubject(Subject subject, String subjectCode);

    Subject enrollStudent(String subjectCode, Long personId);

    Subject findSubjectByCode(String subjectCode);
}
