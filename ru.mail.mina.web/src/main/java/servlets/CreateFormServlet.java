package servlets;

import additional.Helper;
import belski.repository.DAO;
import belski.repository.model.Form;
import belski.repository.model.User;
import belski.service.FormService;
import belski.service.model.FormDTO;
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
public class CreateFormServlet extends HttpServlet {
        private FormService formService = new FormService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("user")!=null) {
            req.getRequestDispatcher("/WEB-INF/pages/createform.jsp").forward(req, resp);
        }
        else {
            req.setAttribute(Helper.message, "Зарегeстрируйтесь!!!");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        if (req.getParameter("CarModel")==null  ) {
            req.setAttribute(Helper.message, "Неверные данный повторите ввод");
            req.getRequestDispatcher("/WEB-INF/pages/createform.jsp").forward(req, resp);
        }
        else {
            FormDTO formDTO = new FormDTO();
            formDTO.setID(0);
            UserDTO userDTO = (UserDTO) httpSession.getAttribute("user"); // cначала идет установка значений
            formDTO.setFK_Users(userDTO.getId());
            formDTO.setCarModel(req.getParameter("CarModel"));
            formDTO.setYearOfIssue(Integer.parseInt(req.getParameter("YearOfIssue")));
            formDTO.setMileage(Integer.parseInt(req.getParameter("MileAge")));
            formDTO.setDescriptionOfBreakage(req.getParameter("DescriptionOfBreakage"));
            if (formService.create(formDTO)) { // и через метод сreate идет добавление в таблицу
                req.setAttribute(Helper.message, "Форма зарегестрирована");
                req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
            }
        }

    }
}
