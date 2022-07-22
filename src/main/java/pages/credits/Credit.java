package pages.credits;

public class Credit {
    private long loanNumber;
    private int loanAmount;
    private int loanTerm;
    private CreditStatus creditStatus = CreditStatus.REPAID;
    private double loanInterestRate;
    private CreditPurpose creditPurpose;
    private double creditPayment;

    public double getCreditPayment() {
        return creditPayment;
    }

    public void setCreditPayment(double creditPayment) {
        this.creditPayment = creditPayment;
    }

    public long getLoanNumber() {
        return loanNumber;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public CreditPurpose getCreditPurpose() {
        return creditPurpose;
    }

    public void setCreditPurpose(CreditPurpose creditPurpose) {
        this.creditPurpose = creditPurpose;
    }

    public void setLoanNumber(long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public CreditStatus getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(CreditStatus creditStatus) {
        this.creditStatus = creditStatus;
    }

    public double getLoanInterestRate() {
        return loanInterestRate;
    }

    public void setLoanInterestRate(double loanInterestRate) {
        this.loanInterestRate = loanInterestRate;
    }

    @Override
    public String toString() {
        return "Credit:" +
                "\n\tLoan Number: " + loanNumber +
                "\n\tLoan Amount: " + loanAmount +
                "\n\tLoan Term: " + loanTerm +
                "\n\tCredit Status: " + creditStatus +
                "\n\tLoan InterestRate: " + loanInterestRate +
                "\n\tCredit Purpose: " + creditPurpose;
    }
}
