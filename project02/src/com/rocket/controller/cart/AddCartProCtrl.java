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

        boolean result = false;
        String prono = request.getParameter("prono");
        String amount = request.getParameter("amount");

        Cart cart = new Cart();
        cart.setAuthor(sid);
        cart.setProno(Integer.parseInt(prono));
        cart.setAmount(Integer.parseInt(amount));
        CartDAO dao = new CartDAO();
        int cnt = dao.addCart(cart);
        if(cnt > 0) {
            result = true;
        }

        JSONObject json = new JSONObject();
        json.put("result", result);
    }
}
