package hellospringboot.demo.dao;

import hellospringboot.demo.entity.Billrecord;

import java.util.List;

public interface BillrecordExtMapper {
    List<Billrecord> GetBillList(Billrecord model);
}
