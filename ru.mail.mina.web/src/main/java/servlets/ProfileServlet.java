package servlets;

import additional.Helper;
import belski.repository.model.Form;
import belski.service.FormService;
import belski.service.model.FormDTO;
import belski.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 25.06.2017.
 */
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession(true);
        if (httpSession.getAttribute("user")!=null) {
            UserDTO userDTO =(UserDTO) httpSession.getAttribute("user");
          List<FormDTO> formsDTO =  new FormService().getAllForms(userDTO); // заберем все данные по пользователю
            req.setAttribute("forms", formsDTO); // установим  лист форм пользователя в параметр запроса
            req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
        }
        else
        {
            req.setAttribute(Helper.message, "Зарегестрируйтесь!");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("user", null);  // тут метод Post обрабатывает клавишу, т.е если
        // нажать logout , то срабоает метод post и т.к в web.xml на данном сервлете прописан путь /profile,
        // то обработка пройдет  c помощью данного сервлета
        req.setAttribute(Helper.message, "Было приятно Вас видеть!!!");

        req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
    }
}
