package com.rocket.util;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.rocket.dto.Files;
import com.rocket.model.FilesDAO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Enumeration;

public class files {

    public int fileUpload(HttpServletRequest request, HttpServletResponse response) {
        int cnt = 0;
        int cntDB = 0;

        ServletContext application = request.getServletContext();
        String home = application.getContextPath();
        try {
            String saveDirectory = application.getRealPath("/storage"); //실제 저장 경로
            int maxSize = 1024*1024*10;     //10MB
            String encoding = "UTF-8";

            MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
            Files files = new Files();
            files.setFiletitle(mr.getParameter("filetitle"));
            files.setPar(mr.getParameter("par"));
            files.setParno(Integer.parseInt(mr.getParameter("parno")));

            File upfile = null;
            Enumeration fileList = mr.getFileNames();

            String item;
            String oriFile = "";
            String fileName = "";
            String filetype = "";
            while(fileList.hasMoreElements()) {
                item = (String) fileList.nextElement();
                oriFile = mr.getOriginalFileName(item); // 실제 첨부된 파일경로와 이름
                fileName = mr.getFilesystemName(item);  // 파일이름만 추출
                filetype = mr.getContentType(item);     // 파일 마임타입 추출
                files.setFiletype(filetype);
                if(fileName!=null) {
                    upfile = mr.getFile(item); //실제 업로드
                    if (upfile.exists()) {
                        long filesize = upfile.length();
                        files.setFilename(upfile.getName());
                        cnt++;
                    } else {
                        cnt--;
                    }
                }
            }

            FilesDAO dao = new FilesDAO();
            cntDB = dao.addFiles(files);
            if(cntDB > 0){
                cnt += cntDB;
            } else {
                cnt -= cntDB;
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return cnt;
    }
}