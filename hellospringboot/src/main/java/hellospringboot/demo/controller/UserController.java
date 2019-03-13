package hellospringboot.demo.controller;

import hellospringboot.demo.entity.user;
import hellospringboot.demo.service.userService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@EnableAutoConfiguration

public class UserController {

    @Resource
    private userService userservice;

    @GetMapping("/user/login")
    private String login(Model model){
        model.addAttribute("user", new  user());
        return "user/login";
    }

    @PostMapping("/user/login")
    private String login(@ModelAttribute user user){

        user logininfo = userservice.getuser(user);
        if(logininfo == null)
            return "user/login";
        else
            return "bill/index";
    }

    @GetMapping("/user/register")
    private String register(Model model){
        model.addAttribute("user", new  user());
        return "user/register";
    }

    @PostMapping("/user/register")
    private String registersubmit(@ModelAttribute user user){
        try {
            user.setUserid(Long.toString(System.currentTimeMillis()));
            user.setCreatetime(new Date());
            user.setLoginname(user.getUsername());
            boolean result = userservice.adduser(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "user/result";
    }
}
