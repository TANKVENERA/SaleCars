package belski.service.model;

import belski.repository.model.Role;

/**
 * Created by Администратор on 29.06.2017.
 */
public class RoleDTO {
    private int id;
    private String role;

    public RoleDTO() {
    }

    public RoleDTO(Role role) {

        this.id = role.getId();
        this.role = role.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }


}
