package hellospringboot.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration

public class UserController {
    @RequestMapping("/user/login")
    private String login(){
        return "user/login";
    }

    @RequestMapping("/user/register")
    private String register(){
        return "user/register";
    }
}
