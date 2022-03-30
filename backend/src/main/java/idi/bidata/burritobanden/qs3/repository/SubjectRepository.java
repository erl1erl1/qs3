package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
