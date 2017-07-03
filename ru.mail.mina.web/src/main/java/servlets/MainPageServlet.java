package servlets;

import additional.Helper;
import belski.repository.DAO;
import belski.repository.model.Form;
import belski.repository.model.User;
import belski.service.FormService;
import belski.service.model.FormDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 24.06.2017.
 */
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        if (httpSession.getAttribute("user") != null) {
            List<FormDTO> formsDTO =  new FormService().getAllForms(null); // заберем все данные по всем клиентам
            req.setAttribute("forms", formsDTO); // установим  лист форм пользователя в параметр запроса
            req.getRequestDispatcher("/WEB-INF/pages/mainpage.jsp").forward(req, resp);
        }
        else {
         req.setAttribute(Helper.message, "Для просмотра очереди всех поломок авторизируйтесь либо пройдите регистрацию.");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        }
    }
}
