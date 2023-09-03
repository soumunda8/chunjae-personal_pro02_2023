package com.rocket.controller.payment;

import com.rocket.dto.Delivery;
import com.rocket.dto.Review;
import com.rocket.model.DeliveryDAO;
import com.rocket.model.PaymentDAO;
import com.rocket.model.ReviewDAO;
import com.rocket.vo.ProductPayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getPayProduct.do")
public class getPayProductCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        int dno = request.getParameter("dno") != null ? Integer.parseInt(request.getParameter("dno")) : 0;

        if(sid != null && dno != 0) {

            DeliveryDAO deliveryDAO = new DeliveryDAO();
            Delivery delivery = deliveryDAO.getDelivery(dno);
            request.setAttribute("delivery", delivery);

            PaymentDAO paymentDAO = new PaymentDAO();
            List<ProductPayList> paymentList = paymentDAO.listProductPayByDno(dno);
            request.setAttribute("paymentList", paymentList);

            RequestDispatcher view = request.getRequestDispatcher("/payment/getPayProduct.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
