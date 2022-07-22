package pages.credits;

import org.apache.log4j.Logger;
import pages.main.MainPage;
import util.ResourceConverter;

import java.io.IOException;
import java.util.Scanner;
/*
    Условия выдачи кредита:
    Если результат деления запрошенной суммы на срок погашения в годах более трети годового дохода --> кредит не выдаётся
    Если в источнике дохода указано "безработный" --> кредит не выдаётся
    Если годовой платёж (включая проценты) больше половины дохода --> кредит не выдаётся
     */
public class Scoring {
    Logger log = Logger.getLogger("APP1");
    Scanner scanner = new Scanner(System.in);
    Credit credit = new Credit();
    int amount; int term; double inRa; CreditPurpose enteredPurpose; double payment;

    public Scoring() throws IOException {
    }

    public void runScoring() throws IOException, InterruptedException {
        AgeVerification av = new AgeVerification();
        av.runScoringRule(); Thread.sleep(1000);

        EnterAmount(); Thread.sleep(1000);
        EnterTerm(); Thread.sleep(1000);
        EnterPurpose(); Thread.sleep(1000);

        CalculationInterestRate interestRate = new CalculationInterestRate();
        interestRate.runScoringRule();
        inRa = 10 + interestRate.getMod();
        //inRa = Math.pow((inRa + Math.log(amount)),2);
        log.info("The interest rate on the loan will be: " + inRa);
        Thread.sleep(1000);

        CalculationAnnualPayment calculationAnnualPayment = new CalculationAnnualPayment();
        calculationAnnualPayment.runScoringRule();
        payment = calculationAnnualPayment.getPayment();
        log.info("The payment on the loan will be: " + payment);

        log.info("Do you agree with the terms of the loan? YES/NO");
        String answer = scanner.nextLine();
        if (answer.equals("YES")) approved();
        else refusal();
    }

    public void EnterAmount() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        CalculationOfTheAmount calculationAmount = new CalculationOfTheAmount();
        calculationAmount.runScoringRule();
        do{
            log.info("Choose the loan amount:");
            amount = sc.nextInt();
            if (amount > calculationAmount.getTotalAmount() || amount <= 0) log.warn("Invalid amount");
        }while (amount > calculationAmount.getTotalAmount());
    }

    public void EnterTerm() throws IOException {
        Scanner sc = new Scanner(System.in);
        do{
            log.info("Choose the loan term:");
            term = sc.nextInt();
            if (term > 20 || term <= 0) log.warn("Invalid term");
        }while (term > 20 || term <= 0);
    }

    public void EnterPurpose(){
        log.info("Choose the purpose of the loan: MORTGAGE, BUSINESS, CAR_LOAN, CONSUMER");
        String pur;
        pur = scanner.nextLine();
        try {
            enteredPurpose = CreditPurpose.valueOf(pur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refusal(){
        log.info("Loan denied!");
        MainPage mainPage = new MainPage();
        try {
            mainPage.display();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void approved() throws IOException {
        log.info("Loan submitted!");
        credit.setLoanAmount(amount);
        credit.setLoanTerm(term);
        credit.setLoanInterestRate(inRa);
        credit.setCreditPurpose(enteredPurpose);
        credit.setCreditPayment(payment);
        credit.setCreditStatus(CreditStatus.ACTIVE);
        ResourceConverter.objectToJson("credit.json", credit);

        MainPage mainPage = new MainPage();
        try {
            mainPage.display();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}