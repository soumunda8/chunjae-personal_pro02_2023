package com.rocket.controller.custom;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/join.do")
public class JoinCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("회원가입 페이지");

        RequestDispatcher view = request.getRequestDispatcher("/custom/join.jsp");
        view.forward(request, response);

    }
}
