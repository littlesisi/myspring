package hellospringboot.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class BillController {
    @RequestMapping("/bill/index")
    private String index(){
        return "bill/index";
    }

}
