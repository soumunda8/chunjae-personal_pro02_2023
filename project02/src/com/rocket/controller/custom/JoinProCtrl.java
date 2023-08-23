package com.rocket.controller.custom;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/joinPro.do")
public class JoinProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("회원가입 insert");

        String msg = request.getParameter("test");

        request.setAttribute("msg", msg);

        response.sendRedirect(request.getContextPath() + "/joinFinish.do?msg="+msg);

    }
}
