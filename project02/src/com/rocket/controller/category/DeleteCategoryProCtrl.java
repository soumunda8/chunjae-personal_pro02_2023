package com.rocket.controller.category;

import com.rocket.model.CategoryDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteCategoryPro.do")
public class DeleteCategoryProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String type = request.getParameter("par");

        if(sid != null && sid.equals("admin")) {
            CategoryDAO dao = new CategoryDAO();
            int cnt = dao.deleteCategory(id);

            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/categoryListAdmin.do?type="+type);
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
