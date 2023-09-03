package com.rocket.controller.payment;

import com.rocket.dto.Cart;
import com.rocket.dto.Delivery;
import com.rocket.dto.Payment;
import com.rocket.dto.Serve;
import com.rocket.model.CartDAO;
import com.rocket.model.DeliveryDAO;
import com.rocket.model.PaymentDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cancelPayPro.do")
public class CancelPayProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        int dno = request.getParameter("dno") != null ? Integer.parseInt(request.getParameter("dno")) : 0;
        
        int paymentCancelCnt = 0;
        int serveCnt = 0;
        int cartCnt = 0;
        int deliveryCnt = 0;

        if(sid != null && dno != 0) {
            Delivery delivery = new Delivery();
            DeliveryDAO deliveryDAO = new DeliveryDAO();
            delivery = deliveryDAO.getDelivery(dno);
            if(0 == delivery.getStatus()) {
                List<Payment> paymentList = new ArrayList<>();
                PaymentDAO paymentDAO = new PaymentDAO();
                paymentList = paymentDAO.listPaymentByDno(dno);
                for(Payment pay : paymentList) {
                    // payment 구매 취소로 변경
                    paymentCancelCnt = paymentDAO.updatePaymentCancel(pay.getPayno());

                    // 입고에 마이너스로 값 입력
                    Serve serve = new Serve();
                    serve.setProno(pay.getProno());
                    serve.setAmount(pay.getAmount() * -1);
                    serve.setSprice(pay.getPayprice() * -1);
                    serveCnt = paymentDAO.addServe(serve);

                    // 장바구니에 다시 담기
                    Cart cart = new Cart();
                    cart.setAuthor(sid);
                    cart.setProno(pay.getProno());
                    cart.setAmount(pay.getAmount());
                    CartDAO dao = new CartDAO();
                    cartCnt = dao.addCart(cart);
                }
                // 배송 테이블 구매취소로 변경
                deliveryCnt = deliveryDAO.updateDeliveryStatus(4, dno);
                if(paymentCancelCnt > 0 && serveCnt > 0 && cartCnt > 0 && deliveryCnt > 0){
                    response.sendRedirect(request.getContextPath()+"/listPayProduct.do");
                } else {
                    response.sendRedirect(request.getContextPath()+"/");
                }
            } else {
                response.sendRedirect(request.getContextPath()+"/");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
