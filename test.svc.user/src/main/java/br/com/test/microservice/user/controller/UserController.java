package br.com.test.microservice.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;

    @GetMapping
    public String getUserByFirstName() {
        return "That it folks";
    }


//    @GetMapping("/{firstName}")
//    public List<User> getUserByFirstName(@PathVariable("firstName") String firstName) {
//        return userService.getUserByFirstName(firstName);
//    }
}
