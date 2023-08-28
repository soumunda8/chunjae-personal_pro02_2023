package com.rocket.dto;

public class Cart {

    private int cartno;
    private String cid;
    private int prono;
    private int amount;

    public int getCartno() {
        return cartno;
    }

    public void setCartno(int cartno) {
        this.cartno = cartno;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    @Override
    public String toString() {
        return "Cart{" +
                "cartno=" + cartno +
                ", cid='" + cid + '\'' +
                ", prono=" + prono +
                ", amount=" + amount +
                '}';
    }

}
