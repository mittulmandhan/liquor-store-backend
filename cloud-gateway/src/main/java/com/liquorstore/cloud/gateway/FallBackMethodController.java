package com.liquorstore.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than usual" +
                "Please try again later!";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "Department Service is taking longer than usual" +
                "Please try again later!";
    }

    @GetMapping("/loginServiceFallBack")
    public String loginServiceFallBackMethod() {
        return "Login Service is taking longer than usual" +
                "Please try again later!";
    }

}
