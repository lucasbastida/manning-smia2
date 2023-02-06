package com.huaylupo.spmia.ch01;

import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping(value = "/{firstName}")
    public HelloResponse helloGET(
            @PathVariable("firstName") String firstName,
            @RequestParam("lastName") String lastName) {

        return HelloResponse.builder()
                .message(String.format("Hello %s %s", firstName, lastName))
                .build();
    }

    @PostMapping
    public HelloResponse helloPOST(@RequestBody HelloRequest request) {
        return HelloResponse.builder()
                .message(String.format("Hello %s %s", request.getFirstName(), request.getLastName()))
                .build();
    }
}

@Builder
@Getter
class HelloResponse {
    private String message;
}

class HelloRequest {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

