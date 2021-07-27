package cucumber;

import com.demo.model.Employee;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringBootBaseTest {
    private final String SERVER_URL = "http://localhost";
    private final String THINGS_ENDPOINT = "/employee-api";

    @LocalServerPort
    private int port=8080;
    private final RestTemplate restTemplate = new RestTemplate();


    private String getBaseEndpoint() {
        return SERVER_URL + ":" + port + THINGS_ENDPOINT;
    }

    public ResponseEntity<Employee> getAll(String relativeUrl) {
        return restTemplate.getForEntity(getBaseEndpoint() + relativeUrl,Employee.class);
    }

    public int post(final String something) {
        return restTemplate.postForEntity(getBaseEndpoint(), something, Void.class).getStatusCodeValue();
    }

    public int put(final String something) {
        return 1;
    }

    public Employee getContents() {
        return restTemplate.getForEntity(getBaseEndpoint(), Employee.class).getBody();
    }

    public void clean() {
        restTemplate.delete(getBaseEndpoint());
    }
}
