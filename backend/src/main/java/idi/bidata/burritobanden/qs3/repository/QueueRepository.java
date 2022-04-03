package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface QueueRepository extends JpaRepository<Queue, Long> {
    List<Queue> findAllBySubjectCode(String subjectCode);
    void deleteBySubjectCodeAndPersonId(String subjectCode, Long personId);
}
