package hellospringboot.demo.service;

import hellospringboot.demo.entity.Billrecord;

import java.util.List;

public interface BillService {
    List<Billrecord> GetBillList(Billrecord model);

    boolean AddBillRecord(Billrecord record);
}
