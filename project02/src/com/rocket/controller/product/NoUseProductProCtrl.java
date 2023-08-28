package com.rocket.controller.product;

import com.rocket.model.ProductDAO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/noUseProductPro.do")
public class NoUseProductProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        ServletContext application = request.getServletContext();
        PrintWriter out = response.getWriter();

        int prono = Integer.parseInt(request.getParameter("prono"));
        boolean useyn = Boolean.parseBoolean(request.getParameter("useyn"));

        if(sid != null) {

            ProductDAO dao = new ProductDAO();
            int cnt = dao.noUseProduct(prono, useyn);

            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/productGetAdmin.do?prono="+prono);
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
