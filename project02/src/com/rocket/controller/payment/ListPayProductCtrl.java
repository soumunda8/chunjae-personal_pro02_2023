package com.rocket.controller.payment;

import com.rocket.model.PaymentDAO;
import com.rocket.vo.ProductPayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listPayProduct.do")
public class ListPayProductCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(sid != null) {

            PaymentDAO paymentDAO = new PaymentDAO();
            List<ProductPayList> paymentList = paymentDAO.listProductPay(sid);
            request.setAttribute("paymentList", paymentList);

            RequestDispatcher view = request.getRequestDispatcher("/payment/listPayProduct.jsp");
            view.forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
