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

@WebServlet("/modifyMyInfoPro.do")
public class ModifyMyInfoProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        String id = request.getParameter("id");
        String rePw = request.getParameter("rePw");
        String pwCk = request.getParameter("pwCk");
        String addr1 = request.getParameter("address1");
        String addr2 = request.getParameter("address2");
        String aCode = request.getParameter("postcode");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String originPw = "";
        String encrypted = "";
        String key = "%02x";

        if(sid != null && sid.equals(id)) {
            MemberDAO dao = new MemberDAO();
            Member member = dao.getMember(sid);
            try {
                originPw = AES256.decryptAES256(member.getPw(), key);
                if(pwCk.equals(rePw)){
                    encrypted = originPw;
                } else {
                    encrypted = rePw;
                }
                encrypted = AES256.encryptAES256(encrypted, key);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            Member modifyMember = new Member();
            modifyMember.setId(id);
            modifyMember.setPw(encrypted);
            modifyMember.setAddr(addr1 + "/" +addr2);
            modifyMember.setTel(tel);
            modifyMember.setEmail(email);
            modifyMember.setAcode(aCode);
            int cnt = dao.modifyMember(modifyMember);
            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/myPage.do");
            }

        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
