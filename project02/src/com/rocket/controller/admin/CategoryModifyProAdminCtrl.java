package com.rocket.controller.admin;

import com.rocket.dto.Category;
import com.rocket.model.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/categoryModifyProAdmin.do")
public class CategoryModifyProAdminCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        String par = request.getParameter("par");
        String cname = request.getParameter("cname");
        String cateno = request.getParameter("cateno");

        if(sid != null && sid.equals("admin")) {
            CategoryDAO dao = new CategoryDAO();
            Category category = new Category();
            category.setCateno(cateno);
            category.setCname(cname);
            category.setPar(par);
            int cnt = dao.modifyCategory(category);
            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/categoryListAdmin.do?type="+par);
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
