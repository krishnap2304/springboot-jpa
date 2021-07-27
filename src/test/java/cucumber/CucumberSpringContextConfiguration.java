package cucumber;

import com.demo.SpringBootJpaApplication;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SpringBootJpaApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringContextConfiguration {


}