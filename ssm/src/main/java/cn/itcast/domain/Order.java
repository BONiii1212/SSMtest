package cn.itcast.domain;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String NOuser;
    private String NObuyuser;
    private Integer NOodernum;
    private String NOname;
    private Integer NOnum;
    private Double NOprice;
    private Integer NOsign;
    private Date NOdate;

    @Override
    public String toString() {
        return "Order{" +
                "NOuser='" + NOuser + '\'' +
                ", NObuyuser='" + NObuyuser + '\'' +
                ", NOodernum=" + NOodernum +
                ", NOname='" + NOname + '\'' +
                ", NOnum=" + NOnum +
                ", NOprice=" + NOprice +
                ", NOsign=" + NOsign +
                ", NOdate=" + NOdate +
                '}';
    }

    public Date getNOdate() {
        return NOdate;
    }

    public void setNOdate(Date NOdate) {
        this.NOdate = NOdate;
    }

    public String getNOuser() {
        return NOuser;
    }

    public void setNOuser(String NOuser) {
        this.NOuser = NOuser;
    }

    public String getNObuyuser() {
        return NObuyuser;
    }

    public void setNObuyuser(String NObuyuser) {
        this.NObuyuser = NObuyuser;
    }

    public Integer getNOodernum() {
        return NOodernum;
    }

    public void setNOodernum(Integer NOodernum) {
        this.NOodernum = NOodernum;
    }

    public String getNOname() {
        return NOname;
    }

    public void setNOname(String NOname) {
        this.NOname = NOname;
    }

    public Integer getNOnum() {
        return NOnum;
    }

    public void setNOnum(Integer NOnum) {
        this.NOnum = NOnum;
    }

    public Double getNOprice() {
        return NOprice;
    }

    public void setNOprice(Double NOprice) {
        this.NOprice = NOprice;
    }

    public Integer getNOsign() {
        return NOsign;
    }

    public void setNOsign(Integer NOsign) {
        this.NOsign = NOsign;
    }
}
