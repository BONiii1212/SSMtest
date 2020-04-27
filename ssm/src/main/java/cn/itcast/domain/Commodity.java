package cn.itcast.domain;

import org.apache.poi.hssf.usermodel.HSSFCell;

import java.io.Serializable;

public class Commodity implements Serializable {
    private String Cuser;
    private String Cname;
    private Double CPprice;
    private Double Cnum;
    private Double Cdiscount;
    private Double Cprice;
    private String Cdescribe;

    @Override
    public String toString() {
        return "Commodity{" +
                "Cuser='" + Cuser + '\'' +
                ", Cname='" + Cname + '\'' +
                ", CPprice=" + CPprice +
                ", Cnum=" + Cnum +
                ", Cdiscount=" + Cdiscount +
                ", Cprice=" + Cprice +
                ", Cdescribe='" + Cdescribe + '\'' +
                '}';
    }

    public String getCuser() {
        return Cuser;
    }

    public void setCuser(String cuser) {
        Cuser = cuser;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public Double getCPprice() {
        return CPprice;
    }

    public void setCPprice(Double CPprice) {
        this.CPprice = CPprice;
    }

    public Double getCnum() {
        return Cnum;
    }

    public void setCnum(Double cnum) {
        Cnum = cnum;
    }

    public Double getCdiscount() {
        return Cdiscount;
    }

    public void setCdiscount(Double cdiscount) {
        Cdiscount = cdiscount;
    }

    public Double getCprice() {
        return Cprice;
    }

    public void setCprice(Double cprice) {
        Cprice = cprice;
    }

    public String getCdescribe() {
        return Cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        Cdescribe = cdescribe;
    }
}
