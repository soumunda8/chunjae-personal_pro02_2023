package com.rocket.test;

import com.rocket.model.DBConnect;
import com.rocket.model.PostGreCon;

import java.sql.*;

public class DBTest {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        DBConnect con = new PostGreCon();
        conn = con.connect();
        if(conn != null) {
            System.out.println("DB 연결 성공");
        }

        String sql = "select * from member";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("sql O");
            }
        } catch (SQLException e) {
            System.out.println("SQL 구문 오류");
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }

    }

}