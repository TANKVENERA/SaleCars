package servlets;

import additional.Helper;
import belski.repository.DAO;
import belski.repository.model.Role;
import belski.repository.model.User;
import belski.service.RoleService;
import belski.service.UserService;
import belski.service.model.RoleDTO;
import belski.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Администратор on 25.06.2017.
 */
public class UsersServlet extends HttpServlet {
        private UserService userService = new UserService();
        private RoleService roleService = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO sessionUser = (UserDTO) req.getSession(true).getAttribute("user");
        if (sessionUser == null) {
            req.setAttribute(Helper.message, "Авторизируйтесь либо пройдите регистрацию.");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        } else if (sessionUser != null && sessionUser.getFk_Role() < 2) {
            req.setAttribute(Helper.message, "Для просмотра списка пользователей необходимы права администратора.");
            req.getRequestDispatcher("/WEB-INF/pages/message.jsp").forward(req, resp);
        } else {

            List<UserDTO> usersDTO = userService.getAllUsers();
            List<RoleDTO> rolesDTO = roleService.getAllRoles();
            req.setAttribute("users", usersDTO);
            req.setAttribute("roles", rolesDTO);
            req.getRequestDispatcher("/WEB-INF/pages/allusers.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(Integer.parseInt(req.getParameter("ID")));
            userDTO.setEmail(req.getParameter("Email"));   //почта
            userDTO.setLogin(req.getParameter("Login"));   //логин
            userDTO.setPassword(req.getParameter("Password"));
            userDTO.setFk_Role(Integer.parseInt(req.getParameter("FK_Role")));
            //Определим, это обновление или удаление.
            if (0 < userDTO.getId()) {
                userService.update(userDTO);
            } else if (0 > userDTO.getId()) {
                userDTO.setId(-1 * userDTO.getId());
                userService.delete(userDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<UserDTO> usersDTO = userService.getAllUsers();
        List<RoleDTO> rolesDTO = roleService.getAllRoles();
        req.setAttribute("users", usersDTO);
        req.setAttribute("roles", rolesDTO);
        req.getRequestDispatcher("/WEB-INF/pages/allusers.jsp").forward(req, resp);
    }

}

