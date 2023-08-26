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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/categoryListAdmin.do")
public class CategoryListAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        String categoryType = request.getParameter("type") != null ? request.getParameter("type") : "board";

        if(sid != null && sid.equals("admin")) {
            CategoryDAO dao = new CategoryDAO();
            List<Category> categoryList = dao.getCategoryList(categoryType);
            request.setAttribute("categoryList", categoryList);

            request.setAttribute("type", categoryType);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/categoryList.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
