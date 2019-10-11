package hellospringboot.demo.dao;

import hellospringboot.demo.entity.Billrecord;
import java.util.List;

public interface BillrecordMapper {
    int deleteByPrimaryKey(String sn);

    int insert(Billrecord record);

    Billrecord selectByPrimaryKey(String sn);

    List<Billrecord> selectAll();

    int updateByPrimaryKey(Billrecord record);

//    List<Billrecord> GetBillList(String userId);
}