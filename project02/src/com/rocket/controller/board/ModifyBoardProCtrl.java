package com.rocket.controller.board;

import com.rocket.model.BoardDAO;
import com.rocket.vo.Board;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/modifyBoardPro.do")
public class ModifyBoardProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int bno = Integer.parseInt(request.getParameter("bno"));

        if(sid != null) {
            BoardDAO dao = new BoardDAO();
            Board board = new Board();
            board.setTitle(title);
            board.setContent(content);
            board.setBno(bno);
            int cnt = dao.updateBoard(board);
            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/getBoard.do?bno="+bno);
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        }else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
