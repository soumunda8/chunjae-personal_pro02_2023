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
    final static String BOARD_SELECT_ALL = "SELECT * FROM boardList WHERE boardType = ? ORDER BY bno DESC";
    final static String BOARD_SELECT_ONE = "SELECT * FROM boardList WHERE bno = ?";
    final static String BOARD_INSERT = "INSERT INTO board VALUES(default, ?, ?, ?, ?, default, default)";
    final static String BOARD_UPDATE = "UPDATE board SET title = ?, content = ? WHERE bno = ?";
    final static String BOARD_UPDATE_VISITED = "UPDATE board SET visited = visited + 1 WHERE bno = ?";
    final static String BOARD_DELETE = "DELETE FROM board WHERE bno = ?";

    /* qna */
    final static String QNA_SELECT_ALL = "SELECT * FROM qnaList ORDER BY qno DESC";
    final static String QNA_SELECT_MY = "SELECT * FROM qnaList WHERE author = ? ORDER BY qno DESC";
    final static String QNA_SELECT_ONE = "SELECT * FROM qnaList WHERE qno = ?";
    final static String QNA_INSERT = "INSERT INTO qna VALUES(default, ?, ?, ?, default, '', default, null)";
    final static String QNA_UPDATE =  "UPDATE qna SET title = ?, content = ? WHERE qno = ?";
    final static String QNA_UPDATE_ANSWER = "UPDATE qna SET answer = ?, answeryn = true, answerdate = CURRENT_TIMESTAMP WHERE = ?";
    final static String QNA_DELETE = "DELETE FROM qna WHERE qno = ?";

    /* comment */
    final static String COMMENT_SELECT_ALL = "SELECT * FROM commentList WHERE bno = ? ORDER BY cno DESC";
    final static String COMMENT_INSERT = "INSERT INTO comment VALUES(default, ?, ?, default, ?)";
    final static String COMMENT_DELETE = "DELETE FROM comment WHERE cno = ?";

    /* product */
    final static String PRODUCT_SELECT_ADMIN_ALL = "SELECT * FROM productList ORDER BY useyn DESC";
    final static String PRODUCT_SELECT_USER_ALL = "SELECT * FROM productList WHERE useyn = true";
    final static String PRODUCT_SELECT_NEW = "SELECT * FROM productList WHERE useyn = true ORDER BY prono DESC LIMIT 5";
    final static String PRODUCT_SELECT_BEST = "SELECT * FROM productList WHERE useyn = true AND prono IN (SELECT prono FROM payment GROUP BY prono ORDER BY SUM(amount) DESC LIMIT 5)";
    final static String PRODUCT_SELECT_CATEGORY = "SELECT * FROM productList WHERE cateno = ? AND useyn = true";
    final static String PRODUCT_SELECT_CATEGORY_NEW = "SELECT * FROM productList WHERE cateno = ? AND useyn = true ORDER BY prono DESC LIMIT 3";
    final static String PRODUCT_SELECT_CATEGORY__BEST = "SELECT * FROM productList WHERE useyn = true AND prono IN (SELECT prono FROM payment GROUP BY prono ORDER BY SUM(amount)) AND cateno = ? LIMIT 3";
    final static String PRODUCT_SELECT_ONE = "SELECT * FROM productList WHERE prono = ?";
    final static String PRODUCT_SELECT_LAST = "SELECT * FROM productList WHERE useyn = true Limit 1";
    final static String PRODUCT_INSERT = "INSERT INTO product VALUES(default, ?, ?, ?, ?, ?, ?, ?, default, default)";
    final static String PRODUCT_UPDATE = "UPDATE product SET cateno = ?, pname = ?, price = ?, pcomment = ?, plist = ?, thumbnail = ?, videosub = ? WHERE prono = ?";
    final static String PRODUCT_NO_USE = "UPDATE product SET useyn = ? WHERE prono = ?";
    final static String PRODUCT_DELETE = "DELETE FROM product WHERE prono = ?";

    /* receive */
    final static String RECEIVE_INSERT = "INSERT INTO receive VALUES (default, ?, ?, ?, default)";

    /* inventory */
    final static String INVENTORY_SELECT_ONE = "SELECT * FROM inventory WHERE prono=?";

    /* serve */
    final static String SERVE_INSERT = "INSERT INTO serve VALUES(default, ?, ?, ?, default)";

    /* category */
    final static String CATEGORY_SELECT_ALL = "SELECT * FROM category WHERE par = ?";
    final static String CATEGORY_SELECT_ONE = "SELECT * FROM category WHERE cateno = ?";
    final static String CATEGORY_INSERT = "INSERT INTO category VALUES(?, ?, ?)";
    final static String CATEGORY_UPDATE = "UPDATE category SET cname = ? WHERE cateno = ?";
    final static String CATEGORY_DELETE = "DELETE FROM category WHERE cateno = ?";

    /* cart */
    final static String CART_INSERT = "INSERT INTO cart VALUES(default, ?, ?, ?)";
    final static String CART_DELETE = "DELETE FROM cart WHERE author = ? and prono = ?";
    final static String CART_SELECT = "SELECT * FROM cartList WHERE author = ?";

    /* payment */
    final static String PRODUCT_PAYMENT_SELECT = "SELECT * FROM productpaylist WHERE author = ? ORDER BY sdate DESC";
    final static String PRODUCT_PAYMENT_SELECT_BY_DNO = "SELECT * FROM productpaylist WHERE dno = ?";
    final static String PAYMENT_SELECT_BY_DNO = "SELECT * FROM payment WHERE dno = ?";
    final static String PAYMENT_INSERT = "INSERT INTO payment VALUES(default, ?, ?, ?, ?, ?, ?, ?, 1, ?, default)";
    final static String PAYMENT_STATUS_CANCEL = "UPDATE payment SET status = 2 WHERE payno = ?";

    /* delivery */
    final static String DELIVERY_SELECT_ADMIN_ALL = "SELECT * FROM delivery";
    final static String DELIVERY_SELECT_ONE = "SELECT * FROM delivery WHERE dno = ?";
    final static String DELIVERY_SELECT_LAST_DNO = "SELECT dno FROM delivery ORDER BY dno DESC Limit 1";
    final static String DELIVERY_INSERT = "INSERT INTO delivery VALUES(default, ?, ?, ?, '', '', default, default, null, '', ?)";
    final static String DELIVERY_UPDATE_ING = "UPDATE delivery SET dnum = ?, dtel = ?, status = 1, dcode = ?, rdate = (SELECT to_timestamp(?, 'yyyy-mm-dd hh24:mi:ss')) WHERE dno = ?";
    final static String DELIVERY_UPDATE_FINISH = "UPDATE delivery SET status = 2, rdate = CURRENT_TIMESTAMP WHERE dno = ?";
    final static String DELIVERY_UPDATE_STATUS = "UPDATE delivery SET status = ? WHERE dno = ?";

    /* review */
    final static String REVIEW_SELECT_BY_PRONO = "SELECT * FROM review WHERE prono = ?";
    final static String REVIEW_SELECT_ONE = "SELECT * FROM review WHERE prono = ? AND author = ?";
    final static String REVIEW_SELECT_BY_RNO = "SELECT * FROM review WHERE rno = ?";
    final static String REVIEW_INSERT = "INSERT INTO review VALUES(default, ?, ?, ?, ?, default)";
    final static String REVIEW_UPDATE = "UPDATE review SET content = ?, star = ? WHERE prono = ? AND author = ?";
    final static String REVIEW_DELETE = "DELETE FROM review WHERE rno=?";


    /* files */
    final static String FILES_INSERT = "INSERT INTO files VALUES(default, ?, ?, ?, ?, ?)";


    public Connection connect();
    public void close(PreparedStatement pstmt, Connection conn);
    public void close(ResultSet rs, PreparedStatement pstmt, Connection conn);

}