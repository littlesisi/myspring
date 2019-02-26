package hellospringboot.demo.service;

import hellospringboot.demo.entity.S1;

public interface S1Service {
    public S1 getS1ById(String ID);

    boolean addS1(S1 record);

}
