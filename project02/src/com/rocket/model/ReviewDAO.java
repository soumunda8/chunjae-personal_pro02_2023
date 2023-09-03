package com.rocket.model;

import com.rocket.dto.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Review> getReviewList(int prono){
        List<Review> reviewList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.REVIEW_SELECT_BY_PRONO);
            pstmt.setInt(1, prono);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Review review = new Review();
                review.setRno(rs.getInt("rno"));
                review.setProno(rs.getInt("prono"));
                review.setAuthor(rs.getString("author"));
                review.setContent(rs.getString("content"));
                review.setStar(rs.getInt("star"));
                review.setResdate(rs.getString("resdate"));
                reviewList.add(review);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            con.close(rs, pstmt, conn);
        }
        return reviewList;
    }

    public Review getReview(int rno) {
        Review review = new Review();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.REVIEW_SELECT_BY_RNO);
            pstmt.setInt(1, rno);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                review.setRno(rs.getInt("rno"));
                review.setAuthor(rs.getString("author"));
                review.setProno(rs.getInt("prono"));
                review.setContent(rs.getString("content"));
                review.setStar(rs.getInt("star"));
                review.setResdate(rs.getString("resdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            con.close(rs, pstmt, conn);
        }
        return review;
    }

    public Review getReview(int prono, String sid) {
        Review review = new Review();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.REVIEW_SELECT_ONE);
            pstmt.setInt(1, prono);
            pstmt.setString(2, sid);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                review.setRno(rs.getInt("rno"));
                review.setAuthor(rs.getString("author"));
                review.setProno(rs.getInt("prono"));
                review.setContent(rs.getString("content"));
                review.setStar(rs.getInt("star"));
                review.setResdate(rs.getString("resdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            con.close(rs, pstmt, conn);
        }
        return review;
    }

    public int addReview(Review review){
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.REVIEW_INSERT);
            pstmt.setInt(1, review.getProno());
            pstmt.setString(2, review.getAuthor());
            pstmt.setString(3, review.getContent());
            pstmt.setInt(4, review.getStar());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int updateReview(Review review){
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.REVIEW_UPDATE);
            pstmt.setString(1, review.getContent());
            pstmt.setInt(2, review.getStar());
            pstmt.setInt(3, review.getProno());
            pstmt.setString(4, review.getAuthor());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int deleteReview(int rno){
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.REVIEW_DELETE);
            pstmt.setInt(1, rno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public Boolean checkReview(int prono, String sid) {
        Boolean pass = false;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.REVIEW_SELECT_ONE);
            pstmt.setInt(1, prono);
            pstmt.setString(2, sid);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                pass = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            con.close(rs, pstmt, conn);
        }
        return pass;
    }

}