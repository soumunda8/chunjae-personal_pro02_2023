package com.rocket.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Main extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        HttpSession session = request.getSession();
        session.setAttribute("sid", "lee");
        */

        ServletContext application = request.getServletContext();
        String realPath = request.getSession().getServletContext().getRealPath("/");

        application.setAttribute("realPath", realPath);  //${realPath }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);

    }
}
