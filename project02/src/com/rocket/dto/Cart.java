package com.rocket.dto;

public class Cart {

    private int cartno;
    private String author;
    private int prono;
    private int amount;

    public int getCartno() {
        return cartno;
    }

    public void setCartno(int cartno) {
        this.cartno = cartno;
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

    @Override
    public String toString() {
        return "Cart{" +
                "cartno=" + cartno +
                ", author='" + author + '\'' +
                ", prono=" + prono +
                ", amount=" + amount +
                '}';
    }

}
