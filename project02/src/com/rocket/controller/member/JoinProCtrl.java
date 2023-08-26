package com.rocket.controller.member;

import com.rocket.dto.Member;
import com.rocket.model.MemberDAO;
import com.rocket.util.AES256;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/joinPro.do")
public class JoinProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String addr1 = request.getParameter("address1");
        String addr2 = request.getParameter("address2");
        String aCode = request.getParameter("postcode");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String birth = request.getParameter("birth");

        int suc = 0;

        MemberDAO dao = new MemberDAO();
        boolean pass = dao.idCheck(id);

        Member member = new Member();
        String key = "%02x";
        String encrypted = "";

        if(pass) {
            try {
                encrypted = AES256.encryptAES256(pw, key);
            } catch (Exception e) {
                e.printStackTrace();
            }

            member.setId(id);
            member.setPw(encrypted);
            member.setName(name);
            member.setAddr(addr1 + "/" +addr2);
            member.setTel(tel);
            member.setEmail(email);
            member.setBirth(birth);
            member.setAcode(aCode);
            suc = dao.addMember(member);

            if(suc>0){
                response.sendRedirect(request.getContextPath() + "/joinFinish.do");
            } else {
                response.sendRedirect(request.getContextPath() + "/join.do");
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/join.do");
        }

    }
}
