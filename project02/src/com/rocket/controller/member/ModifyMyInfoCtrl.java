package com.rocket.controller.member;

import com.rocket.dto.Member;
import com.rocket.model.MemberDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/modifyMyInfo.do")
public class ModifyMyInfoCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        String originPw = "";

        if(sid != null) {

            MemberDAO dao = new MemberDAO();
            Member member = dao.getMember(sid);

            String addr[] = member.getAddr().split("/");

            originPw = dao.getOriginPw(member.getPw(), "myPage");

            request.setAttribute("originPw", originPw);
            request.setAttribute("addr", addr);
            request.setAttribute("member", member);
            RequestDispatcher view = request.getRequestDispatcher("/member/modifyMyInfo.jsp");
            view.forward(request, response);

        } else {

            response.sendRedirect(request.getContextPath()+"/");

        }

    }
}
