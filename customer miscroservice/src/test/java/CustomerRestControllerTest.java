import com.fardi.customermicroservice.CustomerMicroserviceApplication;
import com.fardi.customermicroservice.controller.CustomerController;
import com.fardi.customermicroservice.entity.Customer;
import com.fardi.customermicroservice.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = CustomerMicroserviceApplication.class)

public class CustomerRestControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {
        Customer bassem = new Customer();




        List<Customer> allEmployees = Arrays.asList(bassem);

        given(customerService.findAll()).willReturn(allEmployees);

        mvc.perform(MockMvcRequestBuilders
                        .get("/employees")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email", is(bassem.getEmail())).exists());
    }

}
