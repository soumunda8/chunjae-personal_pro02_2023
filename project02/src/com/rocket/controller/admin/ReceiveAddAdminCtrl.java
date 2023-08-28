package com.rocket.controller.admin;

import com.rocket.model.ProductDAO;
import com.rocket.vo.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addReceiveAdmin.do")
public class ReceiveAddAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        int prono = Integer.parseInt(request.getParameter("prono"));

        if(sid != null && sid.equals("admin")) {
            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(prono);
            request.setAttribute("product", product);

            request.setAttribute("page", "product");

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/receiveAdd.jsp");
            view.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
