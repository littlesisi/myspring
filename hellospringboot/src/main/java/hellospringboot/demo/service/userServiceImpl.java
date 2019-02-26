package hellospringboot.demo.service;

import hellospringboot.demo.dao.userDAO;
import hellospringboot.demo.entity.user;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class userServiceImpl implements userService {

    @Resource
    private userDAO userDao;


    public user getuser(String loginname,String password) {
        return userDao.login(loginname,password);
    }

    public boolean adduser(user record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}