package idi.bidata.burritobanden.qs3.repository;

import idi.bidata.burritobanden.qs3.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person getByUsername(String username);
}
