package hellospringboot.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Billrecord extends QueryEntity {
    private String sn;

    private String userid;

    private String biilName;

    private BigDecimal price;

    private String targetName;

    private String isincome;

    private String billType;

    private Date createtime;

    private Date billtime;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getBiilName() {
        return biilName;
    }

    public void setBiilName(String biilName) {
        this.biilName = biilName == null ? null : biilName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName == null ? null : targetName.trim();
    }

    public String getIsincome() {
        return isincome;
    }

    public void setIsincome(String isincome) {
        this.isincome = isincome == null ? null : isincome.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }
}