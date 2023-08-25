package com.rocket.controller.member;

import com.rocket.dto.Member;
import com.rocket.model.MemberDAO;
import com.rocket.util.AES256;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/myPage.do")
public class MyPageCtrl extends HttpServlet {
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
            RequestDispatcher view = request.getRequestDispatcher("/member/myPage.jsp");
            view.forward(request, response);

        } else {

            response.sendRedirect(request.getContextPath()+"/");

        }

    }
}
