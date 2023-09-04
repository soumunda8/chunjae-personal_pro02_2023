package com.rocket.controller;

import com.rocket.dto.Category;
import com.rocket.model.CartListDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.model.ProductDAO;
import com.rocket.vo.CartList;
import com.rocket.vo.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryDAO headerMenuDao = new CategoryDAO();
        List<Category> headerMenuCategoryList = headerMenuDao.getCategoryList("product");
        request.setAttribute("headerMenuCategoryList", headerMenuCategoryList);

        ServletContext application = request.getServletContext();
        String realPath = request.getSession().getServletContext().getRealPath("/");

        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.getProductNew();
        request.setAttribute("productList", productList);

        application.setAttribute("realPath", realPath);  //${realPath }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);

    }
}
