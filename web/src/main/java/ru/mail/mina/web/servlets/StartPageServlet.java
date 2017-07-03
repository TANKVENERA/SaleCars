package ru.mail.mina.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Администратор on 24.06.2017.
 */
public class StartPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlets.StartPageServlet page"); // пользователь при обновлении посылает get запрос (этот запрос извлекает информ. из сервера)
        //и cервер шлет страницу в ответ, обработав запрос get методом doget
        req.getRequestDispatcher("/WEB-INF/pages/begin-html.jsp").forward(req, resp);
    }
}
