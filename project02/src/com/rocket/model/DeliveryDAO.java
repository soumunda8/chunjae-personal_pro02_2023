package com.rocket.model;

import com.rocket.dto.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Delivery> listDeliveryForAdmin() {
        List<Delivery> deliveryList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.DELIVERY_SELECT_ADMIN_ALL);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Delivery delivery = new Delivery();
                delivery.setDno(rs.getInt("dno"));
                delivery.setCusname(rs.getString("cusname"));
                delivery.setCustel(rs.getString("custel"));
                delivery.setCusaddr(rs.getString("cusaddr"));
                delivery.setDnum(rs.getString("dnum"));
                delivery.setDtel(rs.getString("dtel"));
                delivery.setStatus(rs.getInt("status"));
                delivery.setSdate(rs.getString("sdate"));
                delivery.setRdate(rs.getString("rdate"));
                delivery.setDcode(rs.getString("dcode"));
                delivery.setAuthor(rs.getString("author"));
                deliveryList.add(delivery);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return deliveryList;
    }

    public Delivery getDelivery(int dno) {
        Delivery delivery = new Delivery();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.DELIVERY_SELECT_ONE);
            pstmt.setInt(1, dno);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                delivery.setDno(rs.getInt("dno"));
                delivery.setCusname(rs.getString("cusname"));
                delivery.setCustel(rs.getString("custel"));
                delivery.setCusaddr(rs.getString("cusaddr"));
                delivery.setDnum(rs.getString("dnum"));
                delivery.setDtel(rs.getString("dtel"));
                delivery.setStatus(rs.getInt("status"));
                delivery.setSdate(rs.getString("sdate"));
                delivery.setRdate(rs.getString("rdate"));
                delivery.setDcode(rs.getString("dcode"));
                delivery.setAuthor(rs.getString("author"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return delivery;
    }

    public int addDelivery(Delivery delivery) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.DELIVERY_INSERT);
            pstmt.setString(1, delivery.getCusname());
            pstmt.setString(2, delivery.getCustel());
            pstmt.setString(3, delivery.getCusaddr());
            pstmt.setString(4, delivery.getAuthor());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int getLastDno() {
        int dno = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.DELIVERY_SELECT_LAST_DNO);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dno = rs.getInt("dno");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return dno;
    }

    public int updateDeliveryStatus(int status, int dno) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.DELIVERY_UPDATE_STATUS);
            pstmt.setInt(1, status);
            pstmt.setInt(2, dno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int updateDeliveryStatusIng(Delivery delivery) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.DELIVERY_UPDATE_ING);
            pstmt.setString(1, delivery.getDnum());
            pstmt.setString(2, delivery.getDtel());
            pstmt.setString(3, delivery.getDcode());
            pstmt.setString(4, delivery.getRdate());
            pstmt.setInt(5, delivery.getDno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int updateDeliveryStatusFinish(int dno) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.DELIVERY_UPDATE_FINISH);
            pstmt.setInt(1, dno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }
}
