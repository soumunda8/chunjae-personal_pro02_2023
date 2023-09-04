package com.rocket.dto;

public class Payment {

    private int payno;
    private String author;
    private int prono;
    private int amount;
    private String pmethod;
    private String pcom;
    private String pnum;
    private int payprice;
    private int status;
    private int dno;
    private String resdate;

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
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getDno() {
        return dno;
    }
    public void setDno(int dno) {
        this.dno = dno;
    }
    public String getResdate() {
        return resdate;
    }
    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payno=" + payno +
                ", author='" + author + '\'' +
                ", prono=" + prono +
                ", amount=" + amount +
                ", pmethod='" + pmethod + '\'' +
                ", pcom='" + pcom + '\'' +
                ", pnum='" + pnum + '\'' +
                ", payprice=" + payprice +
                ", status=" + status +
                ", dno=" + dno +
                ", resdate='" + resdate + '\'' +
                '}';
    }

}