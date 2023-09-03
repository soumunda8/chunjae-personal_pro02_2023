package com.rocket.vo;

public class CartList {

    private int prono;
    private String pname;
    private int price;
    private String thumbnail;
    private int amount;
    private String author;
    private int canAmount;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCanAmount() {
        return canAmount;
    }

    public void setCanAmount(int canAmount) {
        this.canAmount = canAmount;
    }

    @Override
    public String toString() {
        return "CartList{" +
                "prono=" + prono +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", thumbbnail='" + thumbnail + '\'' +
                ", amount=" + amount +
                ", author=" + author +
                '}';
    }

}