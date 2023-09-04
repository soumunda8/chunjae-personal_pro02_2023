package com.rocket.model;

import com.rocket.dto.Receive;
import com.rocket.vo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Product> getProductAdminList() {
        List<Product> productList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_ADMIN_ALL);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productList;
    }

    public List<Product> getProductUserList() {
        List<Product> productList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_USER_ALL);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productList;
    }

    public List<Product> getProductNew() {
        List<Product> productList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_NEW);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productList;
    }

    public List<Product> getProductBest() {
        List<Product> productList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_BEST);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productList;
    }

    public List<Product> getProductCategory(String cateno) {
        List<Product> productList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_CATEGORY);
            pstmt.setString(1, cateno);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productList;
    }

    public List<Product> getProductCategoryNew(String cateno) {
        List<Product> productList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_CATEGORY_NEW);
            pstmt.setString(1, cateno);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productList;
    }

    public List<Product> getProductCategoryBest(String cateno) {
        List<Product> productList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_CATEGORY_BEST);
            pstmt.setString(1, cateno);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productList;
    }

    public Product getProduct(int prono) {
        Product product = new Product();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_ONE);
            pstmt.setInt(1, prono);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                product.setProno(rs.getInt("prono"));
                product.setCateno(rs.getString("cateno"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setThumbnail(rs.getString("thumbnail"));
                product.setVideosub(rs.getString("videosub"));
                product.setCname(rs.getString("cname"));
                product.setUseyn(rs.getBoolean("useyn"));
                product.setResdate(rs.getString("resdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return product;
    }

    public int addProduct(Product product) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        Product pro = new Product();

        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_INSERT);
            pstmt.setString(1, product.getCateno());
            pstmt.setString(2, product.getPname());
            pstmt.setInt(3, product.getPrice());
            pstmt.setString(4, product.getPcomment());
            pstmt.setString(5, product.getPlist());
            pstmt.setString(6, product.getThumbnail());
            pstmt.setString(7, product.getVideosub());
            cnt = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_LAST);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                pro.setProno(rs.getInt("prono"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            pstmt = conn.prepareStatement(DBConnect.RECEIVE_INSERT);
            pstmt.setInt(1, pro.getProno());
            pstmt.setInt(2, 0);
            pstmt.setInt(3, 0);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            pstmt = conn.prepareStatement(DBConnect.SERVE_INSERT);
            pstmt.setInt(1, pro.getProno());
            pstmt.setInt(2, 0);
            pstmt.setInt(3, 0);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int modifyProduct(Product product) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_UPDATE);
            pstmt.setString(1, product.getCateno());
            pstmt.setString(2, product.getPname());
            pstmt.setInt(3, product.getPrice());
            pstmt.setString(4, product.getPcomment());
            pstmt.setString(5, product.getPlist());
            pstmt.setString(6, product.getThumbnail());
            pstmt.setString(7, product.getVideosub());
            pstmt.setInt(8, product.getProno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int noUseProduct(int prono, boolean useyn) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_NO_USE);
            pstmt.setBoolean(1, useyn);
            pstmt.setInt(2, prono);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int deleteProduct(int prono) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_DELETE);
            pstmt.setInt(1, prono);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int getAmount(int prono){
        int amount = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.INVENTORY_SELECT_ONE);
            pstmt.setInt(1, prono);
            rs = pstmt.executeQuery();
            if(rs.next()){
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return amount;
    }

    public int addReceive(Receive receive){
        int cnt = 0;
        DBConnect con = new PostGreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.RECEIVE_INSERT);
            pstmt.setInt(1, receive.getProno());
            pstmt.setInt(2, receive.getAmount());
            pstmt.setInt(3, receive.getRprice());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

}