package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a JPA repository interface for assignments. This enables Spring Data to find this interface
 * and create an implementation for it. The DAO already have some CRUD methods defined
 * and implemented.
 */
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    public Assignment findAssignmentByPersonIdAndSubjectCode(Long personId, String subjectCode);
}
