import com.fardi.customermicroservice.entity.Customer;
import com.fardi.customermicroservice.entity.Role;
import com.fardi.customermicroservice.repository.CustomerRepository;
import com.fardi.customermicroservice.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {

        @Bean
        public CustomerService customerService() {
            return new CustomerService();
        }
    }

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void whenValidEmail_thenCustomerShouldBeFound() {
        String email = "bassem.jadoui@esprit.tn";
        Customer found = customerService.findByEmail(email);

        assertThat(found.getEmail()).isEqualTo(email);
    }


    @Before
    public void setUp() {
        Customer bassem = getCustomer();
        Mockito.when(customerRepository.findCustomerByEmail(bassem.getEmail())).thenReturn(bassem);
    }

    private Customer getCustomer() {
        Customer bassem = new Customer();
        bassem.setFirstName("Bassem");
        bassem.setLastName("jadoui");
        bassem.setEmail("bassem.jadoui@esprit.tn");
        bassem.setPassword("123456");
        bassem.setPhone("+21655135774");
        bassem.setRole(Role.ADMIN);
        return bassem;
    }


}
