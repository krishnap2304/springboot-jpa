package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/employee.feature",
        glue = {"com.demo.cucumber.steps.EmployeeStepsDef"})
@AutoConfigureMockMvc
public  final class RestApiCucumberTest {

}