package ru.mail.mina.repository;



import ru.mail.mina.repository.model.Form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by misha on 12.07.2016.
 */
public class FormDAO extends AbstractDAO implements InterfaceDAO<Form> {

    public Form read(int id) {
        List<Form> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    public boolean create(Form form) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "insert INTO form(CarModel,YearOfIssue,Mileage,DescriptionOfBreakage,FK_Users)" +
                        "\n values('%s', '%d', '%d', '%s' ,'%d');",
                form.getCarModel(),
                form.getYearOfIssue(),
                form.getMileage(),
                form.getDescriptionOfBreakage(),
                form.getFK_Users()
        );
        form.setID(executeUpdate(sql));
        return (form.getID() > 0);
    }

    public boolean update(Form form) {
        //локаль нужна,т.к. есть дробные числа. Их нужно указывать через точку
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `form` SET " +
                        "`CarModel`=%s " +
                        ",`YearOfIssue`=%d " +
                        ",`Mileage`=%d" +
                        ",`DescriptionOfBreakage`=%s" +
                        ",`FK_Users`=%d " +
                        " WHERE `form`.`ID` = %d",
                form.getCarModel(),
                form.getYearOfIssue(),
                form.getMileage(),
                form.getDescriptionOfBreakage(),
                form.getFK_Users(),
                form.getID()
        );

        return (0 < executeUpdate(sql));
    }

    public boolean delete(Form form) {
        String sql = String.format(
                "DELETE FROM `form` WHERE `form`.`ID`=%d;", form.getID()
        );
        return (0 < executeUpdate(sql));
    }

    public List<Form> getAll(String WHERE) {
        List<Form> forms = new ArrayList<Form>();
        String sql = "SELECT * FROM form " + WHERE + " ;";
        try {
            Connection connection = Connectioncreator.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Form form = new Form();
                form.setID(rs.getInt("ID"));
                form.setCarModel(rs.getString("CarModel"));
                form.setYearOfIssue(rs.getInt("YearOfIssue"));
                form.setMileage(rs.getInt("Mileage"));
                form.setDescriptionOfBreakage(rs.getString("DescriptionOfBreakage"));
                form.setFK_Users(rs.getInt("FK_Users"));
                forms.add(form);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forms;
    }

}

