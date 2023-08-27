package com.rocket.controller.product;

import com.rocket.dto.Category;
import com.rocket.model.CategoryDAO;
import com.rocket.model.ProductDAO;
import com.rocket.vo.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listProduct.do")
public class ListProductCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cateno = request.getParameter("cateno");

        if(cateno != null) {
            CategoryDAO cateDao = new CategoryDAO();
            Category category = cateDao.getCategory(cateno);
            request.setAttribute("category", category);

            ProductDAO dao = new ProductDAO();
            List<Product> productList = dao.getProductCategory(cateno);
            request.setAttribute("productList", productList);

            RequestDispatcher view = request.getRequestDispatcher("/product/listProduct.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
