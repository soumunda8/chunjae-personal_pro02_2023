package com.rocket.controller.product;

import com.rocket.dto.Category;
import com.rocket.model.CartListDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.model.ProductDAO;
import com.rocket.vo.CartList;
import com.rocket.vo.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listProduct.do")
public class ListProductCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        CategoryDAO headerCategoryDao = new CategoryDAO();
        List<Category> headerMenuCategoryList = headerCategoryDao.getCategoryList("product");
        request.setAttribute("headerMenuCategoryList", headerMenuCategoryList);

        if(sid != null) {
            CartListDAO headerCartListDao = new CartListDAO();
            List<CartList> cartList = headerCartListDao.getCartList(sid);
            request.setAttribute("cartList", cartList);
        }

        String cateno = request.getParameter("cateno");

        ProductDAO dao = new ProductDAO();
        List<Product> productList = new ArrayList<>();

        CategoryDAO cateDao = new CategoryDAO();
        Category category = cateDao.getCategory(cateno);
        request.setAttribute("category", category);
        if(cateno != null) {
            productList = dao.getProductCategory(cateno);
        } else {
            productList = dao.getProductUserList();
        }

        request.setAttribute("productList", productList);

        RequestDispatcher view = request.getRequestDispatcher("/product/listProduct.jsp");
        view.forward(request, response);

    }
}
