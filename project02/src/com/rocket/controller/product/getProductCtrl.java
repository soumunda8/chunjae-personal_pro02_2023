package com.rocket.controller.product;

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

@WebServlet("/getProduct.do")
public class getProductCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int prono = Integer.parseInt(request.getParameter("prono"));

        if(prono != 0) {

            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(prono);
            request.setAttribute("product", product);

            RequestDispatcher view = request.getRequestDispatcher("/product/getProduct.jsp");
            view.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
