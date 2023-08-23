package com.rocket.controller.custom;

import com.rocket.dto.Custom;
import com.rocket.model.CustomDAO;
import com.rocket.util.AES256;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/joinPro.do")
public class JoinProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("회원가입 insert");

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String addr1 = request.getParameter("address1");
        String addr2 = request.getParameter("address2");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String birth = request.getParameter("birth");

        int suc = 0;

        CustomDAO dao = new CustomDAO();
        boolean pass = dao.idCheck(id);

        Custom user = new Custom();
        String key = "%02x";
        String encrypted = "";

        if(pass) {
            try {
                encrypted = AES256.encryptAES256(pw, key);
                System.out.println("비밀번호 암호화 : "+encrypted);
            } catch (Exception e) {
                e.printStackTrace();
            }

            user.setId(id);
            user.setPw(encrypted);
            user.setName(name);
            user.setAddr(addr1 + "<br>" +addr2);
            user.setTel(tel);
            user.setEmail(email);
            user.setBirth(birth);
            suc = dao.addCustom(user);

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
