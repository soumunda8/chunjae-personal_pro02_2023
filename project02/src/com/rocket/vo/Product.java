package com.rocket.vo;

public class Product {

    private int prono;
    private String cateno;
    private String pname;
    private int price;
    private String pcomment;
    private String plist;
    private String thumbnail;
    private String videosub;
    private String cname;
    private boolean useyn;
    private String resdate;

    public int getProno() {
        return prono;
    }
    public void setProno(int prono) {
        this.prono = prono;
    }
    public String getCateno() {
        return cateno;
    }
    public void setCateno(String cateno) {
        this.cateno = cateno;
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
    public String getPcomment() {
        return pcomment;
    }
    public void setPcomment(String pcomment) {
        this.pcomment = pcomment;
    }
    public String getPlist() {
        return plist;
    }
    public void setPlist(String plist) {
        this.plist = plist;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getVideosub() {
        return videosub;
    }
    public void setVideosub(String videosub) {
        this.videosub = videosub;
    }
    public String getCname() {
        return cname;
    }
    public void setCname(String cname) {
        this.cname = cname;
    }
    public boolean isUseyn() {
        return useyn;
    }
    public void setUseyn(boolean useyn) {
        this.useyn = useyn;
    }
    public String getResdate() {
        return resdate;
    }
    public void setResdate(String resdate) {
        this.resdate = resdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prono=" + prono +
                ", cateno='" + cateno + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", pcomment='" + pcomment + '\'' +
                ", plist='" + plist + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", videosub='" + videosub + '\'' +
                ", cname='" + cname + '\'' +
                ", useyn='" + useyn + '\'' +
                ", resdate='" + resdate + '\'' +
                '}';
    }

}