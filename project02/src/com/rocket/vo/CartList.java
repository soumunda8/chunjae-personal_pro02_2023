package com.rocket.vo;

public class CartList {

    private int prono;
    private String pname;
    private int price;
    private String thumbnail;
    private int amount;
    private String cid;

    public int getProno() {
        return prono;
    }

    public void setProno(int prono) {
        this.prono = prono;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "CartList{" +
                "prono=" + prono +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", thumbbnail='" + thumbnail + '\'' +
                ", amount=" + amount +
                ", cid=" + cid +
                '}';
    }

}