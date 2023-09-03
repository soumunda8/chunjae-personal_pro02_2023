package com.rocket.controller.payment;

import com.rocket.dto.Cart;
import com.rocket.dto.Delivery;
import com.rocket.dto.Payment;
import com.rocket.dto.Serve;
import com.rocket.model.CartDAO;
import com.rocket.model.CartListDAO;
import com.rocket.model.DeliveryDAO;
import com.rocket.model.PaymentDAO;
import com.rocket.vo.CartList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/addPayPro.do")
public class AddPayProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        // 데이터 가져오기
        String cusname = request.getParameter("cusname");
        String custel = request.getParameter("custel");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String postcode = request.getParameter("postcode");
        String cusaddr = address1 + "/" + address2 + "/" + postcode;

        String pmethod = request.getParameter("pmethod");
        String pcom = request.getParameter("pcom");
        String pnum = request.getParameter("pnum");

        int deliveryDno = 0;
        int deliveryCnt = 0;
        int paymentCnt = 0;
        int serveCnt = 0;
        int cartCnt = 0;

        if(sid != null) {

            //배송 등록
            Delivery delivery = new Delivery();
            DeliveryDAO deliveryDAO = new DeliveryDAO();
            delivery.setCusname(cusname);
            delivery.setCustel(custel);
            delivery.setCusaddr(cusaddr);
            delivery.setAuthor(sid);
            deliveryCnt = deliveryDAO.addDelivery(delivery);
            deliveryDno = deliveryDAO.getLastDno();

            // 장바구니 내역
            CartListDAO cartListDAO = new CartListDAO();
            List<CartList> cartList = cartListDAO.getCartList(sid);
            for (CartList getCart : cartList) {
                //결제 등록
                Payment pay = new Payment();
                PaymentDAO paymentDAO = new PaymentDAO();
                pay.setAuthor(sid);
                pay.setProno(getCart.getProno());
                pay.setAmount(getCart.getAmount());
                pay.setPmethod(pmethod);
                pay.setPcom(pcom);
                pay.setPnum(pnum);
                pay.setPayprice(getCart.getPrice());
                pay.setDno(deliveryDno);
                paymentCnt = paymentDAO.addPayment(pay);

                //출고 등록
                Serve serve = new Serve();
                serve.setProno(getCart.getProno());
                serve.setAmount(getCart.getAmount());
                serve.setSprice(getCart.getPrice());
                serveCnt = paymentDAO.addServe(serve);

                // 장바구니 삭제
                CartDAO cartDAO = new CartDAO();
                Cart cart = new Cart();
                cart.setAuthor(sid);
                cart.setProno(getCart.getProno());
                cartCnt = cartDAO.removeCart(cart);

            }

            if(deliveryCnt > 0 && paymentCnt > 0 && serveCnt > 0 && cartCnt > 0){
                response.sendRedirect(request.getContextPath()+"/listPayProduct.do");
            } else {
                response.sendRedirect(request.getContextPath()+"/getPay.do");
            }

        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
