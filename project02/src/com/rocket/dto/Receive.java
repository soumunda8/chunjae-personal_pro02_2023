package com.rocket.dto;

public class Receive {

    private int rno;
    private int prono;
    private int amount;
    private int rprice;
    private String resdate;

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
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

    public int getRprice() {
        return rprice;
    }

    public void setRprice(int rprice) {
        this.rprice = rprice;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    @Override
    public String toString() {
        return "Receive{" +
                "rno=" + rno +
                ", prono=" + prono +
                ", amount=" + amount +
                ", rprice=" + rprice +
                ", resdate='" + resdate + '\'' +
                '}';
    }

}