package com.rocket.controller.admin;

import com.rocket.dto.Category;
import com.rocket.model.CategoryDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/productAddAdmin.do")
public class ProductAddAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {
            CategoryDAO dao = new CategoryDAO();
            List<Category> categoryList = dao.getCategoryList("product");
            request.setAttribute("categoryList", categoryList);

            request.setAttribute("page", "product");

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/productAdd.jsp");
            view.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
