package com.rocket.controller.member;

import com.rocket.model.MemberDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteMyInfoPro.do")
public class DeleteMyInfoProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        if(sid != null) {

            String id = request.getParameter("id");

            MemberDAO dao = new MemberDAO();
            int cnt = dao.deleteMember(id);

            if(cnt > 0) {
                if(sid.equals("admin")) {
                    response.sendRedirect(request.getContextPath()+"/memberListAdmin.do");
                } else {
                    String scriptStr = "";
                    scriptStr = "<script>";
                    scriptStr += "alert('회원탈퇴에 성공하였습니다.');";
                    scriptStr += "location.href = '" + request.getContextPath() + "/logout.do'";
                    scriptStr += "</script>";
                    out.println(scriptStr);
                }
            } else {
                out.println("<script>history.go(-1);</script>");
            }

        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
