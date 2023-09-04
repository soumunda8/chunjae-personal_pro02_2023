package com.rocket.controller.board;

import com.rocket.dto.Category;
import com.rocket.model.BoardDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.vo.Board;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/addBoard.do")
public class AddBoardCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        CategoryDAO headerMenuDao = new CategoryDAO();
        List<Category> headerMenuCategoryList = headerMenuDao.getCategoryList("product");
        request.setAttribute("headerMenuCategoryList", headerMenuCategoryList);

        request.setAttribute("sid", sid);

        RequestDispatcher view = request.getRequestDispatcher("/board/addBoard.jsp");
        view.forward(request, response);

    }
}
