package ru.mail.mina.web.servlets;


import ru.mail.mina.service.UserService;
import ru.mail.mina.service.model.UserDTO;
import ru.mail.mina.web.additional.Helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Администратор on 25.06.2017.
 */
public class SignUpServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        if (httpSession.getAttribute("user")==null) {
            req.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(req, resp);
        }
        else {
            req.setAttribute(Helper.message, "Вы уже в системе.");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        }
        System.out.println(" ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);

        if (req.getParameter("Login")!=null && req.getParameter("Password")!=null && req.getParameter("Email")!=null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setLogin(req.getParameter("Login"));
            userDTO.setPassword(req.getParameter("Password"));
            userDTO.setEmail(req.getParameter("Email"));
            userDTO.setFk_Role(Integer.parseInt(req.getParameter("FK_Role")));
            new UserService().create(userDTO); // пробуем  добавить в базу нового клиента
            req.setAttribute(Helper.message, "Вы успешно зарегестрировались!!!");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        }
    }
}
