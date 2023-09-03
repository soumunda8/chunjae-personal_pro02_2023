package com.rocket.controller.review;

import com.rocket.dto.Review;
import com.rocket.model.ReviewDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteReviewPro.do")
public class DeleteReviewProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        int rno = Integer.parseInt(request.getParameter("rno"));
        int dno = Integer.parseInt(request.getParameter("dno"));

        ReviewDAO dao = new ReviewDAO();
        Review review = dao.getReview(rno);

        if(sid != null && (sid.equals("admin") || sid.equals(review.getAuthor()))) {

            int cnt = dao.deleteReview(rno);
            if(cnt > 0) {

                if(dno != 0) {
                    response.sendRedirect(request.getContextPath()+"/getPayProduct.do?dno=" + dno);
                } else {
                    response.sendRedirect(request.getContextPath()+"/getProduct.do?prono=" + review.getProno());
                }
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
