package com.rocket.controller.admin;

import com.rocket.dto.Delivery;
import com.rocket.dto.Member;
import com.rocket.model.DeliveryDAO;
import com.rocket.model.MemberDAO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/payListAdmin.do")
public class PayListAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {

            DeliveryDAO dao = new DeliveryDAO();
            List<Delivery> deliveryList = dao.listDeliveryForAdmin();
            request.setAttribute("deliveryList", deliveryList);

            request.setAttribute("page", "pay");

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/payList.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
