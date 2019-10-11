package hellospringboot.demo.service;

import hellospringboot.demo.dao.UserExtMapper;
import hellospringboot.demo.dao.UserMapper;
import hellospringboot.demo.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class userServiceImpl implements userService {

    @Resource
    private UserMapper userDao;
    @Resource
    private UserExtMapper extuserDao;


    public User GetUser(User record) {
        return extuserDao.Login(record);
    }

    public boolean AddUser(User record){
        boolean result = false;
        try {
            int i = userDao.insert(record);
            if(i >= 0 )
                result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}