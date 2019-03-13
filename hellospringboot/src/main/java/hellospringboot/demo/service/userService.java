package hellospringboot.demo.service;

import hellospringboot.demo.entity.user;

public interface userService {
    public user getuser(user record);

    boolean adduser(user record);
}
