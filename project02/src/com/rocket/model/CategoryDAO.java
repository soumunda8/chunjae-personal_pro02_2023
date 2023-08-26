package com.rocket.model;

import com.rocket.dto.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Category> getCategoryList(String par) {
        List<Category> categoryList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CATEGORY_SELECT_ALL);
            pstmt.setString(1, par);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCateno(rs.getString("cateno"));
                category.setCname(rs.getString("cname"));
                category.setPar(rs.getString("par"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return categoryList;
    }

    public Category getCategory(String id) {
        Category category = new Category();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CATEGORY_SELECT_ONE);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                category.setCateno(rs.getString("cateno"));
                category.setCname(rs.getString("cname"));
                category.setPar(rs.getString("par"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return category;
    }

    public int addCategory(Category category) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CATEGORY_INSERT);
            pstmt.setString(1, category.getCateno());
            pstmt.setString(2, category.getCname());
            pstmt.setString(3, category.getPar());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int modifyCategory(Category category) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CATEGORY_UPDATE);
            pstmt.setString(1, category.getCname());
            pstmt.setString(2, category.getCateno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int deleteCategory(String cateno) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CATEGORY_DELETE);
            pstmt.setString(1, cateno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

}