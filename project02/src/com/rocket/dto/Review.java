package com.rocket.dto;

public class Review {

    private int rno;
    private int prono;
    private String author;
    private String content;
    private int star;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getResdate() {
        return resdate;
    }

    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rno=" + rno +
                ", prono=" + prono +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", star=" + star +
                ", resdate='" + resdate + '\'' +
                '}';
    }

}
