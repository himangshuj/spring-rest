package application;

import application.controller.MvcConfig;
import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

/**
 * Created by himangshu on 15/2/16.
 */


@SpringBootApplication
public class Application {



    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }

}
