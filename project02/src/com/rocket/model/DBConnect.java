package com.rocket.model;

import java.sql.*;

public interface DBConnect {
    
    /* member */
    final static String MEMBER_SELECT_ALL = "SELECT * FROM member WHERE id NOT IN ('admin') ORDER BY useyn DESC, regdate DESC";
    final static String MEMBER_SELECT_ONE = "SELECT * FROM member WHERE id = ?";
    final static String MEMBER_SELECT_LOG = "SELECT * FROM member where id = ? and useyn = true";
    final static String MEMBER_INSERT = "INSERT INTO member VALUES(?, ?, ?, default, default, ?, ?, ?, ?, ?, default, default)";
    final static String MEMBER_UPDATE = "UPDATE member SET pw = ?, tel = ?, email = ?, addr = ?, aCode = ? WHERE id = ?";
    final static String MEMBER_DELETE = "UPDATE member SET useyn = false WHERE id = ?";

    /* board */
    final static String NOTICE_SELECT_ALL = "SELECT * FROM notice ORDER BY no DESC";
    final static String NOTICE_SELECT_ONE = "SELECT * FROM notice WHERE no = ?";
    final static String NOTICE_UPDATE = "UPDATE notice SET title = ?, content = ? WHERE no = ?";
    final static String NOTICE_DELETE = "DELETE FROM notice WHERE no = ?";
    final static String NOTICE_INSERT = "INSERT INTO notice(content, title) VALUES(?, ?)";

    /* product */
    final static String PRODUCT_SELECT_ALL = "SELECT * FROM productList";
    final static String PRODUCT_SELECT_ONE = "SELECT * FROM productList WHERE prono = ?";
    final static String PRODUCT_SELECT_CATEGORY = "SELECT * FROM productList WHERE cateno = ?";
    final static String PRODUCT_INSERT = "INSERT INTO product VALUES(default, ?, ?, ?, ?, ?, ?, ?, default)";
    final static String PRODUCT_UPDATE = "UPDATE product SET cateno = ?, pname = ?, price = ?, pcomment = ?, plist = ?, thumbnail = ?, videosub = ? WHERE prono = ?";
    final static String PRODUCT_DELETE = "DELETE FROM product WHERE prono = ?";

    // product - inventory
    final static String INVENTORY_SELECT_ALL = "select * from inventory order by pno desc";
    final static String INVENTORY_SELECT_ONE = "select * from inventory where pno=?";

    /* category */
    final static String CATEGORY_SELECT_ALL = "SELECT * FROM category WHERE par = ?";
    final static String CATEGORY_SELECT_ONE = "SELECT * FROM category WHERE cateno = ?";
    final static String CATEGORY_INSERT = "INSERT INTO category VALUES(?, ?, ?)";
    final static String CATEGORY_UPDATE = "UPDATE category SET cname = ? WHERE cateno = ?";
    final static String CATEGORY_DELETE = "DELETE FROM category WHERE cateno = ?";

    /* files */
    final static String FILES_INSERT = "INSERT INTO files VALUES(default, ?, ?, ?, ?, ?)";


    public Connection connect();
    public void close(PreparedStatement pstmt, Connection conn);
    public void close(ResultSet rs, PreparedStatement pstmt, Connection conn);

}