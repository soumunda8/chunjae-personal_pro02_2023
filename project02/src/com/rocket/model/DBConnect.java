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
    final static String CUSTOM_SELECT_ALL = "SELECT * FROM custom ORDER BY regdate DESC";
    final static String CUSTOM_SELECT_ONE = "SELECT * FROM custom WHERE id = ?";
    final static String CUSTOM_SELECT_LOG = "SELECT * FROM custom where id = ?";
    final static String CUSTOM_INSERT = "INSERT INTO custom VALUES(?, ?, ?, default, default, ?, ?, ?, ?,default)";
    final static String CUSTOM_UPDATE = "UPDATE custom SET pw = ?, tel = ?, email = ? WHERE id = ?";
    final static String CUSTOM_POINT_UPDATE = "UPDATE custom SET point = ? WHERE id = ?";
    final static String CUSTOM_GRADE_UPDATE = "UPDATE custom SET grade = ? WHERE id = ?";
    final static String CUSTOM_DELETE = "DELETE FROM custom WHERE id = ?";


    public Connection connect();
    public void close(PreparedStatement pstmt, Connection conn);
    public void close(ResultSet rs, PreparedStatement pstmt, Connection conn);

}