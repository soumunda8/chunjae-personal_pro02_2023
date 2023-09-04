package com.rocket.controller.board;

import com.rocket.dto.Category;
import com.rocket.model.BoardDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.vo.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/removeBoardPro.do")
public class RemoveBoardProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        CategoryDAO headerMenuDao = new CategoryDAO();
        List<Category> headerMenuCategoryList = headerMenuDao.getCategoryList("product");
        request.setAttribute("headerMenuCategoryList", headerMenuCategoryList);

        int bno = Integer.parseInt(request.getParameter("bno"));

        BoardDAO dao = new BoardDAO();
        int cnt = dao.deleteBoard(bno);

        RequestDispatcher view = request.getRequestDispatcher("/board/listNotice.jsp");
        view.forward(request, response);
    }
}
