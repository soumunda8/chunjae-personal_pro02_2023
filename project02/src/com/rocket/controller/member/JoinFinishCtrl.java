package com.rocket.controller.member;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/joinFinish.do")
public class JoinFinishCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String msg = request.getParameter("msg");
        request.setAttribute("msg", msg);

        RequestDispatcher view = request.getRequestDispatcher("/member/joinFinish.jsp");
        view.forward(request, response);

    }
}
