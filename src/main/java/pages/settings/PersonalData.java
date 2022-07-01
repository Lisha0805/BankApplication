package pages.settings;

import java.util.Date;

public class PersonalData{

    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateOfBirth;
    private String sex;
    private String sourceOfIncome;
    private int incomePerYear;
    private int creditRating;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }

    public void setIncomePerYear(int incomePerYear) {
        this.incomePerYear = incomePerYear;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }

    public int getIncomePerYear() {
        return incomePerYear;
    }

    public int getCreditRating() {
        return creditRating;
    }
}
