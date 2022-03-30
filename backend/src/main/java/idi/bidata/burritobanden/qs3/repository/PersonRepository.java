package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonRepository extends CrudRepository<Person, Long> {
}
