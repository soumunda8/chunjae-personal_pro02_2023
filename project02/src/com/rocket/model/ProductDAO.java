package com.rocket.model;

import com.rocket.vo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();

        return productList;
    }

    /*
    public int addProduct() {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_INSERT);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPw());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getTel());
            pstmt.setString(5, member.getEmail());
            pstmt.setString(6, member.getBirth());
            pstmt.setString(7, member.getAddr());
            pstmt.setString(8, member.getAcode());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }
    */

}
