package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * This is a JPA repository interface for Queue. This enables Spring Data to find this interface
 * and create an implementation for it. The DAO already have some CRUD methods defined
 * and implemented.
 */
@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
    List<Queue> findAllBySubjectCode(String subjectCode);
    void deleteBySubjectCodeAndPersonId(String subjectCode, Long personId);
}
