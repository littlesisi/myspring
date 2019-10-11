package hellospringboot.demo.service;

import hellospringboot.demo.dao.S1Mapper;
import hellospringboot.demo.entity.S1;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("S1Service")
public class S1ServiceImpl implements S1Service {

    @Resource
    private S1Mapper s1Dao;


    public S1 getS1ById(String ID) {
        return s1Dao.selectByPrimaryKey(ID);
    }

    public boolean addS1(S1 record){
        boolean result = false;
        try {
            s1Dao.insert(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}