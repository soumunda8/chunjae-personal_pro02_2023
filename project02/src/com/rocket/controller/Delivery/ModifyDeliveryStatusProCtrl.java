package com.rocket.controller.Delivery;

import com.rocket.dto.Delivery;
import com.rocket.model.DeliveryDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/modifyDeliveryStatusPro.do")
public class ModifyDeliveryStatusProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        int dno = Integer.parseInt(request.getParameter("dno"));
        int status = Integer.parseInt(request.getParameter("status"));
        String dnum = request.getParameter("dnum") != null ? request.getParameter("dnum") : "";
        String dtel = request.getParameter("dtel") != null ? request.getParameter("dtel") : "";
        String dcode = request.getParameter("dcode") != null ? request.getParameter("dcode") : "";
        String rdate = request.getParameter("rdate") != null ? request.getParameter("rdate") : "";
        int cnt = 0;

        if(sid != null) {

            DeliveryDAO dao = new DeliveryDAO();

            if(status == 1) {
                Delivery delivery = new Delivery();
                delivery.setDno(dno);
                delivery.setDnum(dnum);
                delivery.setDtel(dtel);
                delivery.setDcode(dcode);
                delivery.setRdate(rdate);
                cnt = dao.updateDeliveryStatusIng(delivery);
            } else if(status == 2) {
                cnt = dao.updateDeliveryStatusFinish(dno);
            } else {
                cnt = dao.updateDeliveryStatus(status, dno);
            }

            if(cnt > 0) {
                if(sid.equals("admin")) {
                    response.sendRedirect(request.getContextPath()+"/payGetAdmin.do?dno="+dno);
                } else {
                    response.sendRedirect(request.getContextPath()+"/getPayProduct.do?dno="+dno);
                }
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
