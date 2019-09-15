package com.demo.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestfulMessageController {
    private static final String template = "There are %s users in %s";
    private static final Logger log = LoggerFactory.getLogger(RestfulMessageController.class);

    /**
     * Call using this url http://localhost:8080/users?location=London
     * @param location
     * @return Response
     */
    @RequestMapping("/users")
    public Response getUsers(@RequestParam(value="location", defaultValue="London") String location) {

        if(location == null || location.isEmpty()) {
            location="London";
        }

        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("https://bpdts-test-app.herokuapp.com/city/%s/users",location);

        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(url, User[].class);

        User[] users = responseEntity.getBody();

        log.warn("There are {} users in {}", users.length, location);

        return new Response(String.format(template, users.length, location), users.length);
    }

    /**
     * Call using this url http://localhost:8080/user?id=12
     * @param id
     * @return User
     */
    @RequestMapping("/user")
    public User getUser(@RequestParam(value="id", defaultValue="1") int id) {

        RestTemplate restTemplate = new RestTemplate();

        String url = String.format("https://bpdts-test-app.herokuapp.com/user/%s",id);

        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);

        User user = responseEntity.getBody();

        log.warn("User ID {} for {}", user.getId(), user.getFirst_name());

        return user;
    }
}
