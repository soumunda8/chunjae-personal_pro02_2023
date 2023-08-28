package com.rocket.controller;

import com.rocket.dto.Category;
import com.rocket.model.CartListDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.vo.CartList;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class Main extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        CategoryDAO headerCategoryDao = new CategoryDAO();
        List<Category> categoryHeaderList = headerCategoryDao.getCategoryList("product");
        request.setAttribute("categoryHeaderList", categoryHeaderList);

        if(sid != null) {
            CartListDAO headerCartListDao = new CartListDAO();
            List<CartList> cartList = headerCartListDao.getCartList(sid);
            request.setAttribute("cartList", cartList);
        }

        ServletContext application = request.getServletContext();
        String realPath = request.getSession().getServletContext().getRealPath("/");

        application.setAttribute("realPath", realPath);  //${realPath }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);

    }
}
