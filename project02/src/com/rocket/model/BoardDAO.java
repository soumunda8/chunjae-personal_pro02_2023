package com.rocket.model;

import com.rocket.vo.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Board> getBoardList(String boardType) {
        List<Board> boardList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.BOARD_SELECT_ALL);
            pstmt.setString(1, boardType);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBoardType(rs.getString("boardtype"));
                board.setAuthor(rs.getString("author"));
                board.setContent(rs.getString("content"));
                board.setTitle(rs.getString("title"));
                board.setResdate(rs.getString("resdate"));
                board.setVisited(rs.getInt("visited"));
                boardList.add(board);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }

        return boardList;
    }

    public Board getBoard(int bno) {
        Board board = new Board();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.BOARD_SELECT_ONE);
            pstmt.setInt(1, bno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                board.setBno(rs.getInt("bno"));
                board.setBoardType(rs.getString("boardtype"));
                board.setAuthor(rs.getString("author"));
                board.setContent(rs.getString("content"));
                board.setTitle(rs.getString("title"));
                board.setResdate(rs.getString("resdate"));
                board.setVisited(rs.getInt("visited"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }

        return board;
    }

    public int addBoard(Board board) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.BOARD_INSERT);
            pstmt.setString(1, board.getBoardType());
            pstmt.setString(2, board.getTitle());
            pstmt.setString(3, board.getContent());
            pstmt.setString(4, board.getAuthor());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cnt;
    }

    public int updateBoard(Board board) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.BOARD_UPDATE);
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getBno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cnt;
    }

    public int updateVisitedBoard(int bno) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.BOARD_UPDATE_VISITED);
            pstmt.setInt(1, bno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cnt;
    }

    public int deleteBoard(int bno) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.BOARD_DELETE);
            pstmt.setInt(1, bno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cnt;
    }

    public int getCount(){
        int cnt = 0;
        DBConnect con = new PostGreCon();
        conn = con.connect();

        try {
            pstmt = conn.prepareStatement(DBConnect.BOARD_COUNT);
            rs = pstmt.executeQuery();
            if(rs.next()){
                cnt = rs.getInt("cnt");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cnt;
    }

    public int getCount(String searchType, String kwd){
        int cnt = 0;
        DBConnect con = new PostGreCon();
        conn = con.connect();

        try {
            if(searchType.equals("title")) {
                pstmt = conn.prepareStatement(DBConnect.BOARD_COUNT_TITLE);
                pstmt.setString(1, "%" + kwd + "%");
            } else if(searchType.equals("content")){
                pstmt = conn.prepareStatement(DBConnect.BOARD_COUNT_CONTENT);
                pstmt.setString(1, "%" + kwd + "%");
            } else {
                pstmt = conn.prepareStatement(DBConnect.BOARD_COUNT_ALL);
                pstmt.setString(1, "%" + kwd + "%");
                pstmt.setString(2, "%" + kwd + "%");
            }
            rs = pstmt.executeQuery();
            if(rs.next()){
                cnt = rs.getInt("cnt");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cnt;
    }


}