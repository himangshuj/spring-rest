package application;

import application.config.PersistenceContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by himangshu on 15/2/16.
 */
@Configuration
@ComponentScan("application")
@Import({PersistenceContext.class})
public class TestContext {

}
