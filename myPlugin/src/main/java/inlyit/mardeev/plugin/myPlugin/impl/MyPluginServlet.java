package inlyit.mardeev.plugin.myPlugin.impl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyPluginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8"); // Установка типа контента
        resp.getWriter().write("<h2>Привет! Это страница сервлета!</h2>");
    }
}
