import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootTest(classes = CustomerMicroserviceApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ComponentScans( { @ComponentScan("com.fardi.customermicroservice.service") , @ComponentScan("com.fardi.customermicroservice.repository") })
public class CustomerMicroserviceApplicationTests {
    @Test
    void contextLoads() {
    }
}
