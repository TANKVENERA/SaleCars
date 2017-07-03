package ru.mail.mina.repository.model;


public class Form {

    private int ID;
    private String CarModel;
    private int YearOfIssue;
    private int Mileage;
    private String DescriptionOfBreakage;
    private int FK_Users;

    public Form() {
    }

    public Form(int ID, String CarModel, int YearOfIssue, int Mileage, String DescriptionOfBreakage, int FK_Users) {
        this.ID = ID;
        this.CarModel = CarModel;
        this.YearOfIssue = YearOfIssue;
        this.Mileage = Mileage;
        this.DescriptionOfBreakage = DescriptionOfBreakage;
        this.FK_Users = FK_Users;
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

    @Override
    public String toString() {
        return "form{" +
                "ID=" + ID +
                ", CarModel=" + CarModel +
                ", YearOfIssue=" + YearOfIssue +
                ", Mileage=" + Mileage +
                ", DescriptionOfBreakage=" + DescriptionOfBreakage +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Form form = (Form) o;

        if (ID != form.ID) return false;
        if (CarModel != form.CarModel) return false;
        if (YearOfIssue != form.YearOfIssue) return false;
        if (Mileage != form.Mileage) return false;
        if (FK_Users != form.FK_Users) return false;
        return DescriptionOfBreakage != null ? DescriptionOfBreakage.equals(form.DescriptionOfBreakage) : form.DescriptionOfBreakage == null;

    }

    @Override
    public int hashCode() {
        int result;
        // long temp;
        result = ID;
        result = 31 * result + (CarModel != null ? CarModel.hashCode() : 0);
        result = 31 * result + YearOfIssue;
        result = 31 * result + Mileage;
        result = 31 * result + (DescriptionOfBreakage != null ? DescriptionOfBreakage.hashCode() : 0);
        result = 31 * result + FK_Users;
        return result;
    }
}
