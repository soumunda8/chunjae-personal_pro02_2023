package com.rocket.controller.admin;

import com.rocket.dto.Delivery;
import com.rocket.model.DeliveryDAO;
import com.rocket.model.PaymentDAO;
import com.rocket.vo.ProductPayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/payGetAdmin.do")
public class PayGetAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        int dno = Integer.parseInt(request.getParameter("dno"));

        if(sid != null && sid.equals("admin")) {

            PaymentDAO paymentDAO = new PaymentDAO();
            List<ProductPayList> payList = paymentDAO.listProductPayByDno(dno);
            request.setAttribute("payList", payList);

            DeliveryDAO deliveryDAO = new DeliveryDAO();
            Delivery delivery = deliveryDAO.getDelivery(dno);
            request.setAttribute("delivery", delivery);

            request.setAttribute("page", "pay");

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/payGet.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
