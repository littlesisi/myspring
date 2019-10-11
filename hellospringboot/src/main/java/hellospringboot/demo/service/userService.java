package hellospringboot.demo.service;

import hellospringboot.demo.entity.User;

public interface userService {
    public User GetUser(User record);

    boolean AddUser(User record);
}
