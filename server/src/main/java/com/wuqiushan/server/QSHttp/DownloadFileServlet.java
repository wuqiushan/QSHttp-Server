package com.wuqiushan.server.QSHttp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/QSHttp/Download")
public class DownloadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //用于记录以完成的下载的数据量，单位是byte
        long downloadedLength = 0l;
//        File file = new File("/Users/yyd-wlf/Desktop/123.zip"); // 本地Mac 电脑测试
        File file = new File("/root/QSHttp/nginx-1.16.0.tar.gz"); // 服务器 /root/QSHttp 目录用于测试
        String fileName = file.getName();

        // 长度设置，是为了让客户端有进度条状态， 设置Disposition 是告诉客户端怎么处置，比如这里是文件
        response.setContentLengthLong(file.length());
        response.setHeader("Content-Disposition","attachment;filename=" + fileName);

        //打开本地文件流
        InputStream inputStream = new FileInputStream(file);
        //激活下载操作
        OutputStream os = response.getOutputStream();

        //循环写入输出流
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
            downloadedLength += b.length;
        }

        // 这里主要关闭。
        os.close();
        inputStream.close();
    }
}
