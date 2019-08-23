package com.wuqiushan.server.QSHttp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

@WebServlet("/QSHttp/Upload")
public class UploadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取输出流
//        OutputStream os=new FileOutputStream("/Users/yyd-wlf/Desktop/"+new Date().getTime() + "1234.zip"); //+file.getOriginalFilename());
        OutputStream os=new FileOutputStream("/root/QSHttp/"+new Date().getTime() + "1234.zip"); // 服务器
        //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
        InputStream is=request.getInputStream();

        //循环写入输出流
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) > 0) {
            os.write(b, 0, length);
        }

        os.flush();
        os.close();
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
