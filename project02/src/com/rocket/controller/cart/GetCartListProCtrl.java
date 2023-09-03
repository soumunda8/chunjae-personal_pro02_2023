package com.rocket.controller.cart;

import com.rocket.model.CartListDAO;
import com.rocket.vo.CartList;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/getCartListPro.do")
public class GetCartListProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        //CORS(Cross Origin Resource Sharing) 해제
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        PrintWriter out = response.getWriter();

        if (sid != null) {
            CartListDAO dao = new CartListDAO();
            List<CartList> cartList = dao.getCartList(sid);
            request.setAttribute("cartList", cartList);

            HashMap<String, Object> map = new HashMap<>();
            map.put("cartList", cartList);

            JSONObject json = new JSONObject();
            json.putAll(map);       //List => Array
            out.println(json.toString());
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
