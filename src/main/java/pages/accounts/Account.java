package pages.accounts;

public class Account {
    private long number;
    private AccountCurrency currency;
    private AccountStatus status = AccountStatus.ACTIVE;
    private double balance = 0;

    /*
list:
  - number: 265564
    currency: "BYN"
    status: "ACTIVE"
    balance: 0
  - number: 69393
    currency: "BYN"
    status: "ACTIVE"
    balance: 120.50
     */

    public Account(long number, AccountCurrency currency, AccountStatus status, double balance) {
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

    public AccountCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(AccountCurrency currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", currency=" + currency +
                ", status=" + status +
                ", balance=" + balance +
                '}';
    }
}
