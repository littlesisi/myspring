package hellospringboot.demo.service;

import hellospringboot.demo.dao.BillrecordExtMapper;
import hellospringboot.demo.dao.BillrecordMapper;
import hellospringboot.demo.entity.Billrecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("BillService")
public class BillServiceImpl implements BillService {

    @Resource
    private BillrecordMapper biildao;
    @Resource
    private BillrecordExtMapper extbiildao;

    public List<Billrecord> GetBillList(Billrecord model)
    {
        List<Billrecord> result = null;
        try {
            result = extbiildao.GetBillList(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean AddBillRecord(Billrecord record){
        boolean result = false;
        try {
            int i = biildao.insert(record);
            if(i>0)
                result = true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
