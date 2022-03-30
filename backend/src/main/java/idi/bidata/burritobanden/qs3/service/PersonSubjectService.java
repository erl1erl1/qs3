package idi.bidata.burritobanden.qs3.service;

import idi.bidata.burritobanden.qs3.entity.PersonSubject;

import java.util.List;

public interface PersonSubjectService {
    PersonSubject savePersonSubject(PersonSubject personSubject);

    List<PersonSubject> fetchPersonSubjectList();

    PersonSubject updatePersonSubject(PersonSubject personSubject, Long personSubjectId);

    void deletePersonSubjectById(Long personSubjectId);
}
