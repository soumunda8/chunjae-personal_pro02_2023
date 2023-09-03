package com.rocket.model;

import com.rocket.dto.Payment;
import com.rocket.dto.Serve;
import com.rocket.vo.ProductPayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<ProductPayList> listProductPay(String sid) {
        List<ProductPayList> productPayList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_PAYMENT_SELECT);
            pstmt.setString(1, sid);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ProductPayList productPay = new ProductPayList();
                productPay.setPayno(rs.getInt("payno"));
                productPay.setAuthor(rs.getString("author"));
                productPay.setProno(rs.getInt("prono"));
                productPay.setAmount(rs.getInt("amount"));
                productPay.setPmethod(rs.getString("pmethod"));
                productPay.setPcom(rs.getString("pcom"));
                productPay.setPnum(rs.getString("pnum"));
                productPay.setPayprice(rs.getInt("payprice"));
                productPay.setPaystatus(rs.getInt("paystatus"));
                productPay.setDno(rs.getInt("dno"));
                productPay.setPname(rs.getString("pname"));
                productPay.setThumbnail(rs.getString("thumbnail"));
                productPay.setCusname(rs.getString("cusname"));
                productPay.setCustel(rs.getString("custel"));
                productPay.setCusaddr(rs.getString("cusaddr"));
                productPay.setDnum(rs.getString("dnum"));
                productPay.setDtel(rs.getString("dtel"));
                productPay.setDstatus(rs.getInt("dstatus"));
                productPay.setSdate(rs.getString("sdate"));
                productPay.setRdate(rs.getString("rdate"));
                productPay.setDcode(rs.getString("dcode"));
                productPayList.add(productPay);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productPayList;
    }

    public List<ProductPayList> listProductPayByDno(int dno) {
        List<ProductPayList> productPayList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_PAYMENT_SELECT_BY_DNO);
            pstmt.setInt(1, dno);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ProductPayList productPay = new ProductPayList();
                productPay.setPayno(rs.getInt("payno"));
                productPay.setAuthor(rs.getString("author"));
                productPay.setProno(rs.getInt("prono"));
                productPay.setAmount(rs.getInt("amount"));
                productPay.setPmethod(rs.getString("pmethod"));
                productPay.setPcom(rs.getString("pcom"));
                productPay.setPnum(rs.getString("pnum"));
                productPay.setPayprice(rs.getInt("payprice"));
                productPay.setPaystatus(rs.getInt("paystatus"));
                productPay.setDno(rs.getInt("dno"));
                productPay.setPname(rs.getString("pname"));
                productPay.setThumbnail(rs.getString("thumbnail"));
                productPay.setCusname(rs.getString("cusname"));
                productPay.setCustel(rs.getString("custel"));
                productPay.setCusaddr(rs.getString("cusaddr"));
                productPay.setDnum(rs.getString("dnum"));
                productPay.setDtel(rs.getString("dtel"));
                productPay.setDstatus(rs.getInt("dstatus"));
                productPay.setSdate(rs.getString("sdate"));
                productPay.setRdate(rs.getString("rdate"));
                productPay.setDcode(rs.getString("dcode"));
                productPayList.add(productPay);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return productPayList;
    }

    public List<Payment> listPaymentByDno(int dno) {
        List<Payment> paymentList = new ArrayList<>();
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PAYMENT_SELECT_BY_DNO);
            pstmt.setInt(1, dno);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Payment pay = new Payment();
                pay.setPayno(rs.getInt("payno"));
                pay.setAuthor(rs.getString("author"));
                pay.setProno(rs.getInt("prono"));
                pay.setAmount(rs.getInt("amount"));
                pay.setPmethod(rs.getString("pmethod"));
                pay.setPcom(rs.getString("pcom"));
                pay.setPnum(rs.getString("pnum"));
                pay.setPayprice(rs.getInt("payprice"));
                pay.setStatus(rs.getInt("status"));
                pay.setDno(rs.getInt("dno"));
                pay.setResdate(rs.getString("resdate"));
                paymentList.add(pay);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return paymentList;
    }

    public int addPayment(Payment pay) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PAYMENT_INSERT);
            pstmt.setString(1, pay.getAuthor());
            pstmt.setInt(2, pay.getProno());
            pstmt.setInt(3, pay.getAmount());
            pstmt.setString(4, pay.getPmethod());
            pstmt.setString(5, pay.getPcom());
            pstmt.setString(6, pay.getPnum());
            pstmt.setInt(7, pay.getPayprice());
            pstmt.setInt(8, pay.getDno());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int updatePaymentCancel(int payno) {
        int cnt = 0;
        DBConnect con = new PostGreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PAYMENT_STATUS_CANCEL);
            pstmt.setInt(1, payno);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int addServe(Serve serve){
        int cnt = 0;
        DBConnect con = new PostGreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.SERVE_INSERT);
            pstmt.setInt(1, serve.getProno());
            pstmt.setInt(2, serve.getAmount());
            pstmt.setInt(3, serve.getSprice());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

}
