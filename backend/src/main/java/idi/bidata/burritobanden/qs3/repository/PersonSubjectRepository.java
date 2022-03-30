package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.PersonSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonSubjectRepository extends CrudRepository<PersonSubject, Long> {
}
