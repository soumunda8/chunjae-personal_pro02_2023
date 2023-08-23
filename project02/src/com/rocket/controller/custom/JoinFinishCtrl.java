package com.rocket.controller.custom;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/joinFinish.do")
public class JoinFinishCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("회원가입 완료 페이지");

        String msg = request.getParameter("msg");
        request.setAttribute("msg", msg);

        RequestDispatcher view = request.getRequestDispatcher("/custom/joinFinish.jsp");
        view.forward(request, response);

    }
}
