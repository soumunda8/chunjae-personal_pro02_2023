package com.rocket.controller.cart;

import com.rocket.dto.Cart;
import com.rocket.model.CartDAO;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/removeCartPro.do")
public class RemoveCartProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        boolean result = false;
        int prono = Integer.parseInt(request.getParameter("prono"));

        Cart cart = new Cart();
        cart.setAuthor(sid);
        cart.setProno(prono);
        CartDAO dao = new CartDAO();
        int cnt = dao.removeCart(cart);
        if(cnt > 0) {
            result = true;
        }

        JSONObject json = new JSONObject();
        json.put("result", result);
    }
}
