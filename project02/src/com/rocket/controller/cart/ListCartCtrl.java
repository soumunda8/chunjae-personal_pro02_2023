package com.rocket.controller.cart;

import com.rocket.dto.Category;
import com.rocket.model.CartListDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.model.ProductDAO;
import com.rocket.vo.CartList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listCart.do")
public class ListCartCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        if(sid != null) {
            CategoryDAO headerMenuDao = new CategoryDAO();
            List<Category> headerMenuCategoryList = headerMenuDao.getCategoryList("product");
            request.setAttribute("headerMenuCategoryList", headerMenuCategoryList);

            CartListDAO dao = new CartListDAO();
            List<CartList> cartList = dao.getCartList(sid);
            request.setAttribute("cartList", cartList);

            ProductDAO productDAO = new ProductDAO();
            for(CartList cartCnt : cartList) {
                cartCnt.setCanAmount(productDAO.getAmount(cartCnt.getProno()));
            }

            RequestDispatcher view = request.getRequestDispatcher("/cart/listCart.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
