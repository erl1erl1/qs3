package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a JPA repository interface for Person. This enables Spring Data to find this interface
 * and create an implementation for it. The DAO already have some CRUD methods defined
 * and implemented.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person getByUsername(String username);
}
