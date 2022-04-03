package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a JPA repository interface for Subject. This enables Spring Data to find this interface
 * and create an implementation for it. The DAO already have some CRUD methods defined
 * and implemented.
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBySubjectCode(String subjectCode);

}
