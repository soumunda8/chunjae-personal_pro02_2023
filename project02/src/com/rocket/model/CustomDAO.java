package com.rocket.model;

import com.rocket.dto.*;
import com.rocket.util.AES256;

import java.sql.*;
import java.util.*;

public class CustomDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String key = "%02x";

    public List<Custom> getCustomList(){
        List<Custom> cusList = new ArrayList<>();

        return cusList;
    }

    public Custom getCustom(String id){
        Custom cus = new Custom();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CUSTOM_SELECT_ONE);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                cus.setId(rs.getString("id"));
                cus.setPw(rs.getString("pw"));
                cus.setName(rs.getString("name"));
                cus.setPoint(rs.getInt("point"));
                cus.setGrade(rs.getString("grade"));
                cus.setTel(rs.getString("tel"));
                cus.setEmail(rs.getString("email"));
                cus.setBirth(rs.getString("birth"));
                cus.setRegdate(rs.getString("regdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cus;
    }

    public boolean login(String id, String pw) {
        boolean pass = false;
        DBConnect con = new PostGreCon();
        String qpw = "";

        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CUSTOM_SELECT_LOG);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                try {
                    qpw = AES256.decryptAES256(rs.getString("pw"), key);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                if(pw.equals(qpw)){
                    pass = true;
                } else {
                    pass = false;
                }
            } else {
                pass = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return pass;
    }

    public boolean idCheck(String id){
        Custom cus = new Custom();
        DBConnect con = new PostGreCon();
        boolean pass = false;
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CUSTOM_SELECT_ONE);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                pass = false;
            } else {
                pass = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return pass;
    }

    public int addCustom(Custom user) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            System.out.println(user.toString());
            pstmt = conn.prepareStatement(DBConnect.CUSTOM_INSERT);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPw());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getTel());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getBirth());
            pstmt.setString(7, user.getAddr());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

}
