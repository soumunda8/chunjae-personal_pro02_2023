package com.rocket.dto;

public class Category {

    private String cateno;
    private String cname;
    private String par;

    public String getCateno() {
        return cateno;
    }

    public void setCateno(String cateno) {
        this.cateno = cateno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cateno='" + cateno + '\'' +
                ", cname='" + cname + '\'' +
                ", par='" + par + '\'' +
                '}';
    }

}