package com.rocket.vo;

public class ProductPayList {

    private int payno;
    private String author;
    private int prono;
    private int amount;
    private String pmethod;
    private String pcom;
    private String pnum;
    private int payprice;
    private int paystatus;
    private int dno;
    private String pname;
    private String thumbnail;
    private String cusname;
    private String custel;
    private String cusaddr;
    private String dnum;
    private String dtel;
    private int dstatus;
    private String sdate;
    private String rdate;
    private String dcode;

    public int getPayno() {
        return payno;
    }

    public void setPayno(int payno) {
        this.payno = payno;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getProno() {
        return prono;
    }

    public void setProno(int prono) {
        this.prono = prono;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPmethod() {
        return pmethod;
    }

    public void setPmethod(String pmethod) {
        this.pmethod = pmethod;
    }

    public String getPcom() {
        return pcom;
    }

    public void setPcom(String pcom) {
        this.pcom = pcom;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public int getPayprice() {
        return payprice;
    }

    public void setPayprice(int payprice) {
        this.payprice = payprice;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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

    public int getDstatus() {
        return dstatus;
    }

    public void setDstatus(int dstatus) {
        this.dstatus = dstatus;
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

    @Override
    public String toString() {
        return "ProductPayList{" +
                "payno=" + payno +
                ", author='" + author + '\'' +
                ", prono=" + prono +
                ", amount=" + amount +
                ", pmethod='" + pmethod + '\'' +
                ", pcom='" + pcom + '\'' +
                ", pnum='" + pnum + '\'' +
                ", payprice=" + payprice +
                ", paystatus=" + paystatus +
                ", dno=" + dno +
                ", pname='" + pname + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", cusname='" + cusname + '\'' +
                ", custel='" + custel + '\'' +
                ", cusaddr='" + cusaddr + '\'' +
                ", dnum='" + dnum + '\'' +
                ", dtel='" + dtel + '\'' +
                ", dstatus=" + dstatus +
                ", sdate='" + sdate + '\'' +
                ", rdate='" + rdate + '\'' +
                ", dcode='" + dcode + '\'' +
                '}';
    }

}