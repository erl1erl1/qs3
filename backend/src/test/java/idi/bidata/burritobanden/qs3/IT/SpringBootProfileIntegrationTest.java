package idi.bidata.burritobanden.qs3.IT;

import idi.bidata.burritobanden.qs3.H2TestProfileJPAConfig;
import idi.bidata.burritobanden.qs3.Qs3Application;
import idi.bidata.burritobanden.qs3.controller.PersonController;
import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.repository.PersonRepository;
import idi.bidata.burritobanden.qs3.service.person.PersonService;
import idi.bidata.burritobanden.qs3.service.person.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {
        Qs3Application.class,
        H2TestProfileJPAConfig.class,
        PersonController.class,
        PersonService.class,
        PersonServiceImpl.class,
        PersonRepository.class,
        Person.class
})
@ActiveProfiles("test")
public class SpringBootProfileIntegrationTest {

    @InjectMocks
    PersonController personController;

    @Mock
    PersonService personService;


    @Test
    public void testCreatePerson() throws Exception{

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Person person = new Person();
        person.setPersonId(100L);
        person.setSubjects(null);
        person.setName("test");
        person.setUsername("test");
        person.setPassword("test");
        person.setRole("TEST");


        Person sent = personController.saveUser(person);
        System.out.println("Sent: " + sent);

        List<Person> personList = personController.fetchPersonList();

        System.out.println(personList);

        assertFalse(personList.isEmpty());
    }
}

