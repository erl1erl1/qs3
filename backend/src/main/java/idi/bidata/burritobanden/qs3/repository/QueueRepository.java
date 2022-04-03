package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface QueueRepository extends JpaRepository<Queue, Long> {
    List<Queue> findAllBySubjectCode(String subjectCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE from Queue q WHERE q.subjectCode = :subjectCode AND q.personId = :personId")
    void deleteBySubjectCodeAndPersonId(@Param("subjectCode") String subjectCode, @Param("personId") Long personId);
}
