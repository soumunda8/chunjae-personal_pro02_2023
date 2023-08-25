package com.rocket.model;

import java.sql.*;

public interface DBConnect {

    /* 공지사항 */
    final static String NOTICE_SELECT_ALL = "SELECT * FROM notice ORDER BY no DESC";
    final static String NOTICE_SELECT_ONE = "SELECT * FROM notice WHERE no = ?";
    final static String NOTICE_UPDATE = "UPDATE notice SET title = ?, content = ? WHERE no = ?";
    final static String NOTICE_DELETE = "DELETE FROM notice WHERE no = ?";
    final static String NOTICE_INSERT = "INSERT INTO notice(content, title) VALUES(?, ?)";
    
    /* 고객 */
    final static String MEMBER_SELECT_ALL = "SELECT * FROM member ORDER BY regdate DESC";
    final static String MEMBER_SELECT_ONE = "SELECT * FROM member WHERE id = ?";
    final static String MEMBER_SELECT_LOG = "SELECT * FROM member where id = ?";
    final static String MEMBER_INSERT = "INSERT INTO member VALUES(?, ?, ?, default, default, ?, ?, ?, ?, ?, default)";
    final static String MEMBER_UPDATE = "UPDATE member SET pw = ?, tel = ?, email = ?, addr = ?, aCode = ? WHERE id = ?";
    final static String MEMBER_POINT_UPDATE = "UPDATE member SET point = ? WHERE id = ?";
    final static String MEMBER_GRADE_UPDATE = "UPDATE member SET grade = ? WHERE id = ?";
    final static String MEMBER_DELETE = "DELETE FROM member WHERE id = ?";


    public Connection connect();
    public void close(PreparedStatement pstmt, Connection conn);
    public void close(ResultSet rs, PreparedStatement pstmt, Connection conn);

}