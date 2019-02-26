package hellospringboot.demo.service;

import hellospringboot.demo.entity.user;

public interface userService {
    public user getuser(String loginname,String password);

    boolean adduser(user record);
}
