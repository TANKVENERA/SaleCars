package ru.mail.mina.repository;



import ru.mail.mina.repository.model.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by misha on 12.07.2016.
 */
public class RoleDAO extends AbstractDAO implements InterfaceDAO<Role> {

    public List<Role> getAll(String WHERE) {
        List<Role> roles = new ArrayList<Role>();
        String sql = "SELECT * FROM role " + WHERE + " ;";
        try {
            Connection connection = Connectioncreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("ID"));
                role.setRole(rs.getString("role"));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }


    public Role read(int id) {
        List<Role> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }


    public boolean create(Role role) {
        String sql = String.format(
                "insert INTO role(Role) values('%s',);", role.getRole()
        );
        role.setId(executeUpdate(sql));
        return (role.getId() > 0);
    }


    public boolean update(Role role) {
        String sql = String.format(
                "UPDATE `role` SET `Role` = '%s', WHERE `roles`.`ID` = %d",
                role.getRole(), role.getId()
        );
        return (0 < executeUpdate(sql));
    }


    public boolean delete(Role role) {
        String sql = String.format(
                "DELETE FROM `role` WHERE `roles`.`ID` = %d;", role.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
