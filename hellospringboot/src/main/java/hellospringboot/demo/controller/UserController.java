package hellospringboot.demo.controller;

import hellospringboot.demo.entity.User;
import hellospringboot.demo.service.userService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@EnableAutoConfiguration

public class UserController {

    @Resource
    private userService userservice;

    @GetMapping("/user/login")
    private String login(Model model){
        model.addAttribute("user", new  User());
        return "user/login";
    }

    @PostMapping("/user/login")
    private String login(@ModelAttribute User user, HttpServletResponse response){

        User logininfo = userservice.GetUser(user);
        if(logininfo == null) {
            return "user/login";
        }
        else {
            Cookie cookie = new Cookie("user",logininfo.getUserid());
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/bill/index";
        }
    }

    @GetMapping("/user/register")
    private String register(Model model){
        model.addAttribute("user", new  User());
        return "user/register";
    }

    @PostMapping("/user/register")
    private String registersubmit(@ModelAttribute User user){
        try {
            user.setUserid(Long.toString(System.currentTimeMillis()));
            user.setCreatetime(new Date());
            user.setLoginname(user.getUsername());
            boolean result = userservice.AddUser(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "user/result";
    }
}
