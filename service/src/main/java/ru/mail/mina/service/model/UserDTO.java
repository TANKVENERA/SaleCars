package ru.mail.mina.service.model;


import ru.mail.mina.repository.model.User;

/**
 * Created by Администратор on 29.06.2017.
 */
public class UserDTO {
    private int id = 0;
    private String login;
    private String password;
    private String email;
    private Integer fk_Role = 0;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password =user.getPassword() ;
        this.email = user.getEmail();
        this.fk_Role = user.getFk_Role();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getFk_Role() {
        return fk_Role;
    }

    public void setFk_Role(Integer fk_Role) {
        this.fk_Role = fk_Role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
