package hellospringboot.demo.dao;

import hellospringboot.demo.entity.user;

public interface userDAO {
    int deleteByPrimaryKey(String userid);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    user login(user record);
}