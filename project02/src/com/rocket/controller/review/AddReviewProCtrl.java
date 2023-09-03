package com.rocket.controller.review;

import com.rocket.dto.Review;
import com.rocket.model.ReviewDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addReviewPro.do")
public class AddReviewProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        boolean pass = Boolean.parseBoolean(request.getParameter("pass"));
        int dno = Integer.parseInt(request.getParameter("dno"));
        int prono = Integer.parseInt(request.getParameter("prono"));
        int star = Integer.parseInt(request.getParameter("star"));
        String content = request.getParameter("content");

        if(sid != null) {

            ReviewDAO dao = new ReviewDAO();

            Review review = new Review();
            review.setProno(prono);
            review.setContent(content);
            review.setStar(star);
            review.setAuthor(sid);

            int cnt = 0;
            if(pass) {
                cnt = dao.updateReview(review);
            } else {
                cnt = dao.addReview(review);
            }

            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/getPayProduct.do?dno=" + dno);
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
