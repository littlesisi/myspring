package hellospringboot.demo.controller;

import hellospringboot.demo.entity.S1;
import hellospringboot.demo.entity.Users;
import hellospringboot.demo.service.S1Service;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/hello")
    private String index(){
        return "Hello World!";
    }
    @RequestMapping("/hello2")
    private String index2(Model model){
        List<Users> userList = new ArrayList<Users>();

        for (int i = 0; i < 9; i++) {
            Users dto = new Users();

            dto.setId((long) i);
            dto.setUsername("pepstack-" + i);
            dto.setAddress("Shanghai, China");
            dto.setAge(20 + i);

            userList.add(dto);
        }
        model.addAttribute("users", userList);
        return "hello2";
    }

    @Resource
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/users1")
    private String SS(Model model){
        String sql = "SELECT * FROM S1";
        List<S1> userList = jdbcTemplate.query(sql,new RowMapper<S1>() {
            S1 user = null;
            public S1 mapRow(ResultSet rs,int rowNum) throws SQLException
            {
                user = new S1();
                user.setID(rs.getString("ID"));
                user.setUser_name(rs.getString("User_name"));
                return user;
            }});
        for(S1 user:userList){
            System.out.println(user.getUser_name());
        }
        model.addAttribute("users", userList);
        return "hello/users1";


    }
    @Resource
    private S1Service s1Service;
    @RequestMapping("/users2")
    private String SS2(Model model) {
        S1 user = this.s1Service.getS1ById("11");
        model.addAttribute("user", user);
        return "hello/users2";
    }

}
