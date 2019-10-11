package hellospringboot.demo.dao;

import hellospringboot.demo.entity.S1;
import java.util.List;

public interface S1Mapper {
    int deleteByPrimaryKey(String id);

    int insert(S1 record);

    S1 selectByPrimaryKey(String id);

    List<S1> selectAll();

    int updateByPrimaryKey(S1 record);
}