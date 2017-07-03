package ru.mail.mina.service;



import ru.mail.mina.repository.DAO;
import ru.mail.mina.repository.model.User;
import ru.mail.mina.service.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 29.06.2017.
 */
public class UserService {

    private DAO dao = DAO.getDAO();

    public UserDTO getUser(String login, String password) {
        User user = dao.user.getAll(
                String.format("where Login='%s' and Password='%s'", login, password)
        ).get(0);
        UserDTO userDTO = new UserDTO(user); // просто передадим пользователя в сущность DTO, которая
        // потом будет вызвана из сервлета
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = dao.user.getAll("");
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        for (User user : users) {
            usersDTO.add(new UserDTO(user));
        }
        return usersDTO;
    }


    public UserDTO read(int id) {
        User user = dao.user.read(id);
        if (user != null) {
            return new UserDTO(user);
        } else
            return null;
    }
    public boolean create(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setFk_Role(userDTO.getFk_Role());
        return dao.user.create(user);

    }

    public boolean update(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setFk_Role(userDTO.getFk_Role());
        user.setId(userDTO.getId());
        return dao.user.update(user);
    }

    public boolean delete(UserDTO userDTO) {
        User user = dao.user.read(userDTO.getId());
        return dao.user.delete(user);
    }

}
