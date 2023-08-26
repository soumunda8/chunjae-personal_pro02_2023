package com.rocket.controller.admin;

import com.rocket.dto.Member;
import com.rocket.model.MemberDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/memberListAdmin.do")
public class MemberListAdminCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(sid != null && sid.equals("admin")) {
            MemberDAO dao = new MemberDAO();
            List<Member> memberList = new ArrayList<>();

            memberList = dao.getMemberList();
            request.setAttribute("memberList", memberList);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/memberList.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
