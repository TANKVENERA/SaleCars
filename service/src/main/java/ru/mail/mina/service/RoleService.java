package ru.mail.mina.service;



import ru.mail.mina.repository.DAO;
import ru.mail.mina.repository.model.Role;
import ru.mail.mina.service.model.RoleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 30.06.2017.
 */
public class RoleService {
    private DAO dao = DAO.getDAO();


    public List<RoleDTO> getAllRoles () {
        List<Role> roles = dao.role.getAll("");
        List<RoleDTO> rolesDTO = new ArrayList<>();
        for (Role role : roles) {
            rolesDTO.add(new RoleDTO(role));
        }
        return rolesDTO;
    }

    public RoleDTO read (int id) {
        Role role = dao.role.read(id);
        if (role!=null) {
            return new RoleDTO(role);
        }
        else
            return null;
    }
    public boolean create (RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setRole(roleDTO.getRole());
        return dao.role.delete(role);
    }

    public boolean update (RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setRole(roleDTO.getRole());
        return dao.role.delete(role);
    }

    public boolean delete (RoleDTO roleDTO) {
        Role role = dao.role.read(roleDTO.getId());
        return dao.role.delete(role);
    }
}
