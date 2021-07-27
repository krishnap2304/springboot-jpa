package cucumber.steps;

import com.demo.SpringBootJpaApplication;
import cucumber.AbstractDefs;
import cucumber.SpringBootBaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

@RunWith(Cucumber.class)
@ContextConfiguration(classes = SpringBootJpaApplication.class)
@WebAppConfiguration
@SpringBootTest
public class EmployeeStepsDef extends AbstractDefs {

    private SpringBootBaseTest testClient = new SpringBootBaseTest();
    String emp_name;
    String baseUri = "http://localhost:8080/employee-api";
    String endPointUri = " ";
    ResponseEntity response;
    RestTemplate restTemplate = new RestTemplate();


    @Given("client set get employees service api endpoint")
    public void client_set_get_employees_service_api_endpoint(){
        endPointUri = baseUri + "/get-all-employees";
        System.out.println("Add URL :" + endPointUri);
    }

    @When("client sends a get HTTP request")
    public void client_sends_a_get_HTTP_request() {
       response = executeGet(endPointUri);
       assertNotNull(response);
    }


    @Then("client receives a valid response")
    public void client_receives_a_valid_response() {
        assertNotNull(response);
        assertNotNull(response.getStatusCodeValue());
    }


}
