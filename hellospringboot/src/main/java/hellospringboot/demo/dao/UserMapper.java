package hellospringboot.demo.dao;

import hellospringboot.demo.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    User selectByPrimaryKey(String userid);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

//    User Login(User record);

}