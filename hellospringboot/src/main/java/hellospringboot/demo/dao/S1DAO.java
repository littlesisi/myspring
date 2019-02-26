package hellospringboot.demo.dao;

import hellospringboot.demo.entity.S1;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface S1DAO {
    int deleteByPrimaryKey(String ID);

    int insert(S1 record);

    int insertSelective(S1 record);

    S1 selectByPrimaryKey(String ID);

    int updateByPrimaryKeySelective(S1 record);

    int updateByPrimaryKey(S1 record);
}