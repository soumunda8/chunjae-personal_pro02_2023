package com.rocket.controller.product;

import com.rocket.dto.Category;
import com.rocket.dto.Review;
import com.rocket.model.CategoryDAO;
import com.rocket.model.ProductDAO;
import com.rocket.model.ReviewDAO;
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

@WebServlet("/getProduct.do")
public class GetProductCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        CategoryDAO headerCategoryDao = new CategoryDAO();
        List<Category> headerMenuCategoryList = headerCategoryDao.getCategoryList("product");
        request.setAttribute("headerMenuCategoryList", headerMenuCategoryList);

        int prono = Integer.parseInt(request.getParameter("prono"));

        if(prono != 0) {
            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(prono);
            int amount = dao.getAmount(prono);

            ReviewDAO reviewDAO = new ReviewDAO();
            List<Review> reviewList = reviewDAO.getReviewList(prono);
            request.setAttribute("reviewList", reviewList);

            request.setAttribute("product", product);
            request.setAttribute("amount", amount);

            RequestDispatcher view = request.getRequestDispatcher("/product/getProduct.jsp");
            view.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
