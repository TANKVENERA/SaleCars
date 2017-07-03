package belski.service;

import belski.repository.DAO;
import belski.repository.model.Form;
import belski.repository.model.User;
import belski.service.model.FormDTO;
import belski.service.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 29.06.2017.
 */
public class FormService {

    private DAO dao = DAO.getDAO();


    public List<FormDTO> getAllForms (UserDTO userDTO) {
        List<FormDTO> formsDTO = new ArrayList<FormDTO>();
        if (userDTO!=null) {
            List<Form> forms = dao.form.getAll("WHERE FK_Users='" + userDTO.getId() + "'");
            for (Form form : forms ) {
                formsDTO.add(new FormDTO(form));
            }
            return formsDTO;
        }
       else {
            List<Form> forms = dao.form.getAll("");
            for (Form form : forms ) {
                formsDTO.add(new FormDTO(form));
            }
            return formsDTO;
        }
    }

    public FormDTO read (int id) {
        Form form = dao.form.read(id);
        if (form!=null) {
            System.out.println(form.toString());
            return new FormDTO(form);
        }
        else
            return null;
    }

    public boolean create (FormDTO formDTO) {
        Form form = new Form();
        form.setCarModel(formDTO.getCarModel());
        form.setID(formDTO.getID());
        form.setMileage(formDTO.getMileage());
        form.setYearOfIssue(formDTO.getYearOfIssue());
        form.setDescriptionOfBreakage(formDTO.getDescriptionOfBreakage());
        form.setFK_Users(formDTO.getFK_Users());
        return dao.form.create(form);
    }

    public boolean update (FormDTO formDTO) {
        Form form = new Form();
        form.setCarModel(formDTO.getCarModel());
        form.setID(formDTO.getID());
        form.setMileage(formDTO.getMileage());
        form.setYearOfIssue(formDTO.getYearOfIssue());
        form.setDescriptionOfBreakage(formDTO.getDescriptionOfBreakage());
        form.setFK_Users(formDTO.getFK_Users());
        return dao.form.update(form);
    }

    public  boolean delete (FormDTO formDTO) {
        Form form = dao.form.read(formDTO.getID());
        return dao.form.delete(form);

    }

}
