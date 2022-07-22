package pages.settings;

import java.time.LocalDate;
import java.time.Period;

public class PersonalData{

    private String firstName;
    private String lastName;
    private String patronymic;
    private String dateOfBirth;
    private PersonalDataSex sex;
    private PersonalDataSourceOfIncome sourceOfIncome;
    private int incomePerYear;
    private int creditRating;
    private int age;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(PersonalDataSex sex) {
        this.sex = sex;
    }

    public void setSourceOfIncome(PersonalDataSourceOfIncome sourceOfIncome) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public PersonalDataSex getSex() {
        return sex;
    }

    public PersonalDataSourceOfIncome getSourceOfIncome() {
        return sourceOfIncome;
    }

    public int getIncomePerYear() {
        return incomePerYear;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PersonalData:" +
                "\n\tFirst Name: " + firstName +
                "\n\tLast Name: " + lastName +
                "\n\tPatronymic: " + patronymic +
                "\n\tDate Of Birth: " + dateOfBirth +
                "\n\tSex: " + sex +
                "\n\tSource Of Income: " + sourceOfIncome +
                "\n\tIncome Per Year: " + incomePerYear +
                "\n\tCredit Rating: " + creditRating;
    }

    public void calculateAge(){
        String[] parts = dateOfBirth.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        age = Period.between(birthDate, currentDate).getYears();
    }
}