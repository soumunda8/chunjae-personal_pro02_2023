package com.rocket.controller.product;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.rocket.vo.Product;
import com.rocket.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/addProductPro.do")
public class AddProductProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("sid");

        PrintWriter out = response.getWriter();

        String msg = "";
        ServletContext application = request.getServletContext();

        if(sid != null) {
            try {
                String saveDirectory = application.getRealPath("/storage"); //실제 저장 경로
                int maxSize = 1024*1024*10;     //10MB
                String encoding = "UTF-8";

                MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
                Product product = new Product();
                product.setPname(mr.getParameter("pname"));
                product.setCateno(mr.getParameter("cateno"));
                product.setPrice(Integer.parseInt(mr.getParameter("price")));
                product.setPcomment(mr.getParameter("pcomment"));
                product.setPlist(mr.getParameter("plist"));

                File upfile = null;
                Enumeration fileList = mr.getFileNames();

                int idx = 1;
                String item = "";
                String oriFile = "";
                String fileName = "";
                while(fileList.hasMoreElements()) {
                    item = (String) fileList.nextElement();
                    oriFile = mr.getOriginalFileName(item); // 실제 첨부된 파일경로와 이름
                    fileName = mr.getFilesystemName(item);  // 파일이름만 추출
                    if(fileName!=null) {
                        upfile = mr.getFile(item); //실제 업로드
                        if (upfile.exists()) {
                            long filesize = upfile.length();
                            if(idx==1) {
                                product.setVideosub(upfile.getName());
                            } else if(idx==2){
                                product.setThumbnail(upfile.getName());
                            }
                            msg = "파일 등록 성공";
                        } else {
                            msg = "파일 등록 실패";
                        }
                    }
                    idx++;
                }

                ProductDAO dao = new ProductDAO();
                int cnt = dao.addProduct(product);
                if(cnt>0){
                    response.sendRedirect(request.getContextPath()+"/productListAdmin.do");
                } else {
                    out.println("<script>history.go(-1);</script>");
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }

        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
