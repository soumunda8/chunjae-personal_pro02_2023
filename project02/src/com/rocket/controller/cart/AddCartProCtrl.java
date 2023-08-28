package com.rocket.controller.cart;

import com.rocket.dto.Cart;
import com.rocket.model.CartDAO;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addCartPro.do")
public class AddCartProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        boolean pass = false;
        int prono = Integer.parseInt(request.getParameter("prono"));
        int amount = Integer.parseInt(request.getParameter("amount"));

        if(sid != null) {
            Cart cart = new Cart();
            cart.setCid(sid);
            cart.setProno(prono);
            cart.setAmount(amount);
            CartDAO dao = new CartDAO();
            int cnt = dao.addCart(cart);

            JSONObject json = new JSONObject();
            if(cnt > 0) {
                pass = true;
            } else {
                pass = false;
            }


            json.put("result", pass);
            out.println(json.toString());

            /*if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/getProduct.do?prono="+prono);
            } else {
                out.println("<script>history.go(-1);</script>");
            }*/
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
