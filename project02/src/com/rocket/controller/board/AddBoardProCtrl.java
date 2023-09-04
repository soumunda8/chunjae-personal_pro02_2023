package com.rocket.controller.board;

import com.rocket.dto.Category;
import com.rocket.model.BoardDAO;
import com.rocket.model.CategoryDAO;
import com.rocket.vo.Board;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBoardPro.do")
public class AddBoardProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String boardType = request.getParameter("boardType");

        if(sid != null) {
            BoardDAO dao = new BoardDAO();
            Board board = new Board();
            board.setTitle(title);
            board.setContent(content);
            board.setBoardType(boardType);
            board.setAuthor(sid);
            int cnt = dao.addBoard(board);
            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/listNotice.do");
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
