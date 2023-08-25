package com.rocket.model;

import com.rocket.dto.*;
import com.rocket.util.AES256;

import java.sql.*;
import java.util.*;

public class MemberDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String key = "%02x";

    public List<Member> getMemberList(){
        List<Member> memberList = new ArrayList<>();

        return memberList;
    }

    public Member getMember(String id){
        Member member = new Member();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.MEMBER_SELECT_ONE);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                member.setId(rs.getString("id"));
                member.setPw(rs.getString("pw"));
                member.setName(rs.getString("name"));
                member.setPoint(rs.getInt("point"));
                member.setGrade(rs.getString("grade"));
                member.setTel(rs.getString("tel"));
                member.setEmail(rs.getString("email"));
                member.setBirth(rs.getString("birth"));
                member.setAddr(rs.getString("addr"));
                member.setAcode(rs.getString("acode"));
                member.setRegdate(rs.getString("regdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return member;
    }

    public String getOriginPw(String pw, String type) {

        String originPw = "";

        try {
            originPw = AES256.decryptAES256(pw, key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(!type.equals("login")) {
            String checkPw = originPw.substring(0, 2);
            for(int i = 0; i < originPw.length()-2; i++) {
                checkPw += "*";
            }
            originPw = checkPw;
        }

        return originPw;
    }

    public boolean login(String id, String pw) {
        boolean pass = false;
        DBConnect con = new PostGreCon();
        String originPw = "";

        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.MEMBER_SELECT_LOG);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                originPw = getOriginPw(rs.getString("pw"), "login");
                if(pw.equals(originPw)){
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
        DBConnect con = new PostGreCon();
        boolean pass = false;
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.MEMBER_SELECT_ONE);
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

    public int addMember(Member user) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            System.out.println(user.toString());
            pstmt = conn.prepareStatement(DBConnect.MEMBER_INSERT);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getPw());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getTel());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getBirth());
            pstmt.setString(7, user.getAddr());
            pstmt.setString(8, user.getAcode());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

}
