package com.rocket.controller.product;

import com.rocket.model.ProductDAO;
import com.rocket.vo.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteProductPro.do")
public class DeleteProductProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        ServletContext application = request.getServletContext();
        PrintWriter out = response.getWriter();

        int prono = Integer.parseInt(request.getParameter("prono"));

        if(sid != null && sid.equals("admin")) {
            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(prono);

            // 등록된 썸네일 및 동영상 삭제
            String fileDirectory = application.getRealPath("/storage"); //실제 저장 경로
            String thumbnailDirectory = fileDirectory + "/" + product.getThumbnail();
            File deleteThumbnailFile = new File(thumbnailDirectory);
            if(deleteThumbnailFile.exists()) {
                deleteThumbnailFile.delete();// 파일 삭제
            }

            String videoDirectory = fileDirectory + "/" + product.getVideosub();
            File deleteVideoFile = new File(videoDirectory);
            if(deleteVideoFile.exists()) {
                deleteVideoFile.delete();// 파일 삭제
            }

            int cnt = dao.deleteProduct(prono);

            if(cnt > 0) {
                response.sendRedirect(request.getContextPath()+"/productListAdmin.do");
            } else {
                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
