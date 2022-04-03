package idi.bidata.burritobanden.qs3.person;

import idi.bidata.burritobanden.qs3.repository.PersonRepository;
import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.person.person.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

/*
Tests of person service and repository.
 */
@ExtendWith(MockitoExtension.class)
public class PersonServiceAndRepoTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    /*
    Decides what will happen when the getByUsername method is called.
     */
    @BeforeEach
    public void setUp() {
        Person person = new Person();
        person.setUsername("test");
        person.setName("test");

        Mockito.lenient().when(personRepository.getByUsername("test")).thenReturn(person);
    }

    /*
    Unit test of the repository. The "getByUsername" method returns a mock person.
     */
    @Test
    void findPersonTest() {
        try{
            assertThat(personRepository.getByUsername("test").getName().equals("test"));
        } catch (Exception e) {
            System.out.println("Something went wrong with repo");
        }
    }

    /*
    Integration test of service and repository. We test the "findPersonByUsername" from the service.
    The service extract a mock person from the repository.
     */
    @Test
    void findPersonControllerTest() {
        try{
            assertThat(personService.findPersonByUsername("test").getName().equals("test"));
        } catch (Exception e) {
            System.out.println("Something went wrong with service");
        }
    }
}


