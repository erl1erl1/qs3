package idi.bidata.burritobanden.qs3.UnitTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.service.PersonServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonServiceTest {
    PersonServiceImpl personServiceImpl = new PersonServiceImpl();

    @Test
    void testFetchPersonList() {
        List<Person> personList = personServiceImpl.fetchPersonList();
        assertTrue(personList.isEmpty());
    }
}
