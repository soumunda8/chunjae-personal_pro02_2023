package com.rocket.controller.cart;

import com.rocket.model.CartListDAO;
import com.rocket.vo.CartList;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getCartListPro.do")
public class getCartListProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        List<CartList> cartList = null;
        if (sid != null) {
            CartListDAO headerCartListDao = new CartListDAO();
            cartList = headerCartListDao.getCartList(sid);
            request.setAttribute("cartList", cartList);

            System.out.println(cartList);

            JSONObject json = new JSONObject();
            json.put("cartList", cartList);
            out.println(json.toString());

        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
