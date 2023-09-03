package com.rocket.model;

import com.rocket.vo.CartList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartListDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<CartList> getCartList(String sid) {
        List<CartList> cartList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CART_SELECT);
            pstmt.setString(1, sid);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                CartList cart = new CartList();
                cart.setProno(rs.getInt("prono"));
                cart.setPname(rs.getString("pname"));
                cart.setPrice(rs.getInt("price"));
                cart.setThumbnail(rs.getString("thumbnail"));
                cart.setAmount(rs.getInt("amount"));
                cart.setAuthor(rs.getString("author"));
                cartList.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cartList;
    }

}
