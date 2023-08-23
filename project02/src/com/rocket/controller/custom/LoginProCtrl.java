package com.rocket.controller.custom;

import com.rocket.model.CustomDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginPro.do")
public class LoginProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String msg = "loginLog";

        CustomDAO dao = new CustomDAO();
        boolean pass = false;
        try {
            pass = dao.login(id, pw);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        RequestDispatcher view;

        if(pass){
            session.setAttribute("sid", id);
            response.sendRedirect(request.getContextPath()+"/");
        } else {
            msg = "fail";
            response.sendRedirect(request.getContextPath()+"/login.do?msg="+msg);
        }

    }
}
