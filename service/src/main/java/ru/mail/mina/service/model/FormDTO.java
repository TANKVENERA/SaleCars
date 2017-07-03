package ru.mail.mina.service.model;


import ru.mail.mina.repository.model.Form;

/**
 * Created by Администратор on 29.06.2017.
 */
public class FormDTO {
    private int ID;
    private String CarModel;
    private int YearOfIssue;
    private int Mileage;
    private String DescriptionOfBreakage;
    private int FK_Users;

    public FormDTO() {
    }

    public FormDTO(Form form) {
        this.ID = form.getID();
        this.CarModel = form.getCarModel();
        this.YearOfIssue = form.getYearOfIssue();
        this.Mileage = form.getMileage();
        this.DescriptionOfBreakage = form.getDescriptionOfBreakage();
        this.FK_Users = form.getFK_Users();
    }


    public int getID() {

        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        CarModel = carModel;
    }

    public int getYearOfIssue() {
        return YearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        YearOfIssue = yearOfIssue;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    public String getDescriptionOfBreakage() {
        return DescriptionOfBreakage;
    }

    public void setDescriptionOfBreakage(String descriptionOfBreakage) {
        DescriptionOfBreakage = descriptionOfBreakage;
    }


    public int getFK_Users() {
        return FK_Users;
    }

    public void setFK_Users(int FK_Users) {
        this.FK_Users = FK_Users;
    }
}
