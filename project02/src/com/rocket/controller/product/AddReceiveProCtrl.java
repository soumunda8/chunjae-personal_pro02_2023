package com.rocket.controller.product;

import com.rocket.dto.Receive;
import com.rocket.model.ProductDAO;
import com.rocket.vo.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addReceivePro.do")
public class AddReceiveProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        int prono = Integer.parseInt(request.getParameter("prono"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        int rprice = Integer.parseInt(request.getParameter("rprice"));


        if(sid != null) {
            ProductDAO dao = new ProductDAO();
            Receive receive = new Receive();
            receive.setProno(prono);
            receive.setAmount(amount);
            receive.setRprice(rprice);

            int cnt = dao.addReceive(receive);

            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/productGetAdmin.do?prono="+prono);
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
