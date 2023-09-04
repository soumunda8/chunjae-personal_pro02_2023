package com.rocket.dto;

public class Delivery {

    private int dno;
    private String cusname;
    private String custel;
    private String cusaddr;
    private String dnum;
    private String dtel;
    private int status;
    private String sdate;
    private String rdate;
    private String dcode;
    private String author;

    public int getDno() {
        return dno;
    }
    public void setDno(int dno) {
        this.dno = dno;
    }
    public String getCusname() {
        return cusname;
    }
    public void setCusname(String cusname) {
        this.cusname = cusname;
    }
    public String getCustel() {
        return custel;
    }
    public void setCustel(String custel) {
        this.custel = custel;
    }
    public String getCusaddr() {
        return cusaddr;
    }
    public void setCusaddr(String cusaddr) {
        this.cusaddr = cusaddr;
    }
    public String getDnum() {
        return dnum;
    }
    public void setDnum(String dnum) {
        this.dnum = dnum;
    }
    public String getDtel() {
        return dtel;
    }
    public void setDtel(String dtel) {
        this.dtel = dtel;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getSdate() {
        return sdate;
    }
    public void setSdate(String sdate) {
        this.sdate = sdate;
    }
    public String getRdate() {
        return rdate;
    }
    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
    public String getDcode() {
        return dcode;
    }
    public void setDcode(String dcode) {
        this.dcode = dcode;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "dno=" + dno +
                ", cusname='" + cusname + '\'' +
                ", custel='" + custel + '\'' +
                ", cusaddr='" + cusaddr + '\'' +
                ", dnum='" + dnum + '\'' +
                ", dtel='" + dtel + '\'' +
                ", status='" + status + '\'' +
                ", sdate='" + sdate + '\'' +
                ", rdate='" + rdate + '\'' +
                ", dcode='" + dcode + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}