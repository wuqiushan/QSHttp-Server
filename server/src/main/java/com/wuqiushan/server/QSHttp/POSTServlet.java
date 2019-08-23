package com.wuqiushan.server.QSHttp;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/QSHttp/POST")
public class POSTServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("application/json;charset=utf-8");
            Map<String, Object> infoMap = new HashMap<>();
            infoMap.put("statusMsg", "success");
            infoMap.put("statusCode", 200);
            infoMap.put("content", "POST测试");

            String infoJson = new Gson().toJson(infoMap);
            response.getWriter().write(infoJson);

        } catch (Exception e) {
            throw e;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
