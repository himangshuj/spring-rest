package application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by himangshu on 15/2/16.
 */

@RestController
public class Index {

       @RequestMapping("/")
        public String index() {
            return "Greetings from Spring Boot!";
        }


}
