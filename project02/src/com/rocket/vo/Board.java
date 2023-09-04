package com.rocket.vo;

public class Board {

    private int bno;
    private String boardType;
    private String title;
    private String content;
    private String author;
    private String resdate;
    private int visited;

    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getBoardType() {
        return boardType;
    }
    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getResdate() {
        return resdate;
    }
    public void setResdate(String resdate) {
        this.resdate = resdate;
    }
    public int getVisited() {
        return visited;
    }
    public void setVisited(int visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bno=" + bno +
                ", boardType=" + boardType +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", resdate='" + resdate + '\'' +
                ", visited=" + visited +
                '}';
    }

}