package com.rocket.controller;

import com.rocket.util.files;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/fileUpload.do")
public class FileUploadTestCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        files files = new files();
        int cnt = files.fileUpload(request, response);
        System.out.println(cnt);

    }
}
