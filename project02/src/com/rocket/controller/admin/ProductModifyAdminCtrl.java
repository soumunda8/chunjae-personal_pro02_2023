package com.rocket.controller.admin;

import com.rocket.dto.Category;
import com.rocket.model.CategoryDAO;
import com.rocket.model.ProductDAO;
import com.rocket.vo.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/productModifyAdmin.do")
public class ProductModifyAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        int prono = Integer.parseInt(request.getParameter("prono"));

        if(sid != null && sid.equals("admin")) {
            CategoryDAO cateDao = new CategoryDAO();
            List<Category> categoryList = cateDao.getCategoryList("product");
            request.setAttribute("categoryList", categoryList);

            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(prono);
            request.setAttribute("product", product);

            request.setAttribute("page", "product");

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/productModify.jsp");
            view.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
