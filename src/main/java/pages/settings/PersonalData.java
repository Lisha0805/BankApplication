package pages.settings;

import java.time.LocalDate;
import java.time.Period;

public class PersonalData{

    private String firstName;
    private String lastName;
    private String patronymic;
    private String dateOfBirth;
    private String sex;
    private String sourceOfIncome;
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

    public String getDateOfBirth() {
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

    public int getAge() {
        return age;
    }

    public void calculateAge(){
        String[] parts = dateOfBirth.split("-");
        int part1 = Integer.parseInt(parts[0]);
        int part2 = Integer.parseInt(parts[1]);
        int part3 = Integer.parseInt(parts[2]);

        LocalDate birthDate = LocalDate.of(part1, part2, part3);
        LocalDate currentDate = LocalDate.now();
        age = Period.between(birthDate, currentDate).getYears();
    }
}
