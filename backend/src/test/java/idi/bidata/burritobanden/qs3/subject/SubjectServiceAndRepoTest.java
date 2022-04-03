package idi.bidata.burritobanden.qs3.subject;

import idi.bidata.burritobanden.qs3.repository.SubjectRepository;
import idi.bidata.burritobanden.qs3.entity.Subject;
import idi.bidata.burritobanden.qs3.person.subject.SubjectServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

/*
Tests of subject service and repository.
 */
@ExtendWith(MockitoExtension.class)
public class SubjectServiceAndRepoTest {

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Mock
    private SubjectRepository subjectRepository;

    /*
    Decides what will happen when the findBySubjectCode method is called.
     */
    @BeforeEach
    public void setUp() {
        Subject subject = new Subject();
        subject.setSubjectCode("test1");
        subject.setSubjectName("test2");
        subject.setAssignments(5);

        Mockito.lenient().when(subjectRepository.findBySubjectCode("test1")).thenReturn(subject);
    }

    /*
   Integration test of service and repository. We test the "findSubjectByCode" from the service.
   The service extract a mock person from the repository.
    */
    @Test
    void findSubjectByCodeServiceTest() {
        try {
            assertThat(subjectService.findSubjectByCode("test1").getSubjectCode().equals("test1"));
        } catch (Exception e) {
            System.out.println("Something went wrong in service");
            Assertions.fail();
        }
    }

    /*
   Unit test of the repository. The "findBySubjectCode" method returns a mock person.
    */
    @Test
    void createSubjectRepository() {
        try {
            assertThat(subjectRepository.findBySubjectCode("test1").getSubjectName().equals("test2"));
        } catch (Exception e) {
            System.out.println("Something went wrong in repository");
            Assertions.fail();
        }
    }

}


