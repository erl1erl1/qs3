package idi.bidata.burritobanden.qs3;

import idi.bidata.burritobanden.qs3.controller.PersonController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        Qs3Application.class,
        H2TestProfileJPAConfig.class
})
@ActiveProfiles("test")
public class SmokeTest {

    @Autowired
    PersonController personController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(personController).isNotNull();
    }
}
