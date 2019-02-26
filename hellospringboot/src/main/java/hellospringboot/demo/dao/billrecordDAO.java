package hellospringboot.demo.dao;

import hellospringboot.demo.entity.billrecord;

public interface billrecordDAO {
    int deleteByPrimaryKey(String sn);

    int insert(billrecord record);

    int insertSelective(billrecord record);

    billrecord selectByPrimaryKey(String sn);

    int updateByPrimaryKeySelective(billrecord record);

    int updateByPrimaryKey(billrecord record);
}