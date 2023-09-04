package com.rocket.controller.board;

import com.rocket.dto.Category;
import com.rocket.model.BoardDAO;
import com.rocket.model.CartListDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.model.ProductDAO;
import com.rocket.vo.Board;
import com.rocket.vo.CartList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listNotice.do")
public class ListNoticeCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        CategoryDAO headerMenuDao = new CategoryDAO();
        List<Category> headerMenuCategoryList = headerMenuDao.getCategoryList("product");
        request.setAttribute("headerMenuCategoryList", headerMenuCategoryList);

        BoardDAO dao = new BoardDAO();
        List<Board> boardList = dao.getBoardList("0010");       // 0010 공지사항
        request.setAttribute("boardList", boardList);

        request.setAttribute("sid", sid);

        RequestDispatcher view = request.getRequestDispatcher("/board/listBoard.jsp");
        view.forward(request, response);

    }
}
