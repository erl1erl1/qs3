package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.Subject;

import java.util.List;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    List<Subject> fetchSubjectList();

    Subject updateSubject(Subject subject, Long subjectId);

    void deleteSubjectById(Long subjectId);
}
