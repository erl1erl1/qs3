package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AssignmentRepository extends CrudRepository<Assignment, Long> {
}
