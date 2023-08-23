package com.rocket.controller.custom;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/joinTerm.do")
public class JoinTermCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("약관동의 페이지");

        RequestDispatcher view = request.getRequestDispatcher("/custom/joinTerm.jsp");
        view.forward(request, response);

    }
}
