package pages.accounts;

public class Account {
    private long number;
    private EnumCurrency currency;
    private EnumStatus status;
    private double balance;

    /*
number: 265564
currency: "BYN"
status: "ACTIVE"
balance: 0
---
number: 0645
currency: "BYN"
status: "ACTIVE"
balance: 120
     */

    public Account(long number, EnumCurrency currency, EnumStatus status, double balance) {
        this.number = number;
        this.currency = currency;
        this.status = status;
        this.balance = balance;
    }

    public Account() {

    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public EnumCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(EnumCurrency currency) {
        this.currency = currency;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
