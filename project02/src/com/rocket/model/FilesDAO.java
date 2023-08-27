package com.rocket.model;

import com.rocket.dto.Files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilesDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public int addFiles(Files files) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.FILES_INSERT);
            pstmt.setString(1, files.getFiletitle());
            pstmt.setString(2, files.getFilename());
            pstmt.setString(3, files.getFiletype());
            pstmt.setString(4, files.getPar());
            pstmt.setInt(5, files.getParno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

}