package com.rocket.controller.admin;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/categoryAddAdmin.do")
public class CategoryAddAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        String par = request.getParameter("type") != null ? request.getParameter("type") : "board";

        request.setAttribute("par", par);

        if(sid != null && sid.equals("admin")) {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/categoryAdd.jsp");
            view.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
