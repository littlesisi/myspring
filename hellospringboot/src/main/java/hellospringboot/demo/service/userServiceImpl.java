package hellospringboot.demo.service;

import hellospringboot.demo.dao.userDAO;
import hellospringboot.demo.entity.user;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class userServiceImpl implements userService {

    @Resource
    private userDAO userDao;


    public user getuser(user record) {
        return userDao.login(record);
    }

    public boolean adduser(user record){
        boolean result = false;
        try {
            int i = userDao.insertSelective(record);
            result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}