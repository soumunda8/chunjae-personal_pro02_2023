package com.rocket.model;

import com.rocket.dto.Cart;

import java.sql.*;

public class CartDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public int addCart(Cart cart) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CART_INSERT);
            pstmt.setString(1, cart.getAuthor());
            pstmt.setInt(2, cart.getProno());
            pstmt.setInt(3, cart.getAmount());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int removeCart(Cart cart) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CART_DELETE);
            pstmt.setString(1, cart.getAuthor());
            pstmt.setInt(2, cart.getProno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }
}