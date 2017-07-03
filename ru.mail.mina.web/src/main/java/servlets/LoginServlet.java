package servlets;

import additional.Helper;
import belski.service.UserService;
import belski.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Администратор on 25.06.2017.
 */
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(true).getAttribute("user") != null) {
            req.setAttribute(Helper.message, "Вы уже зарегестрированы!!!");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String login = req.getParameter("Login");
            String password = req.getParameter("Password");
            UserService userService = new UserService();
            UserDTO userDTO = userService.getUser(login, password);
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("user", userDTO); // устанавиливает пользователеля в текущую сессию

            req.setAttribute(Helper.message, "Добро пожаловать, " + userDTO.getLogin() + "!");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
            //  System.out.println(user.getFk_Role());
        } catch (Exception e) {
            System.out.println(" Неверные данные");
            req.setAttribute(Helper.message, "Неверные данные повторите ввод!");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        }
    }
}
