package com.rocket.controller.admin;

import com.rocket.vo.Product;
import com.rocket.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/productListAdmin.do")
public class ProductListAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {

            ProductDAO dao = new ProductDAO();
            List<Product> productList = dao.getProductList();
            request.setAttribute("productList", productList);

            request.setAttribute("page", "product");

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/productList.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
