package com.rocket.controller.review;

import com.rocket.dto.Review;
import com.rocket.model.ProductDAO;
import com.rocket.model.ReviewDAO;
import com.rocket.vo.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/getReview.do")
public class GetReviewCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        int prono = request.getParameter("prono") != null ? Integer.parseInt(request.getParameter("prono")) : 0;
        int dno = request.getParameter("dno") != null ? Integer.parseInt(request.getParameter("dno")) : 0;

        if(sid != null) {

            ReviewDAO dao = new ReviewDAO();
            boolean pass = dao.checkReview(prono, sid);
            request.setAttribute("pass", pass);

            request.setAttribute("prono", prono);
            request.setAttribute("dno", dno);

            Review review = dao.getReview(prono, sid);
            request.setAttribute("review", review);

            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.getProduct(prono);
            request.setAttribute("product", product);

            RequestDispatcher view = request.getRequestDispatcher("/review/addReview.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
