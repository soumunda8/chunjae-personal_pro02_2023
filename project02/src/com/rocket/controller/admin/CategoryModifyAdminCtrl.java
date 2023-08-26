package com.rocket.controller.admin;

import com.rocket.dto.Category;
import com.rocket.model.CategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/categoryModifyAdmin.do")
public class CategoryModifyAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        String id = request.getParameter("id");

        if(sid != null && sid.equals("admin")) {
            CategoryDAO dao = new CategoryDAO();
            Category category = dao.getCategory(id);
            request.setAttribute("category", category);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/categoryModify.jsp");
            view.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
