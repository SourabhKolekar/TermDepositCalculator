package org.example;

import org.example.model.TermDeposit;
import org.example.service.CalculateService;

import java.util.Scanner;

import static org.example.utils.Frequency.getFrequencyFromSelection;

public class TermDepositCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter term deposit amount starting with: ");
            double initialDepositAmount = scanner.nextDouble();

            System.out.println("Enter interest rate: ");
            double interestRate = scanner.nextDouble();

            System.out.println("Enter Investment term:");
            int investmentTerm = scanner.nextInt();

            System.out.println("select how interest is paid (Enter the number): \n1. Monthly \n 2. Quarterly \n 3. Yearly" +
                               " \n 4. At Maturity");
            int frequencySelection = scanner.nextInt();
            String frequency = getFrequencyFromSelection(frequencySelection);

            // Create a TermDeposit record
            TermDeposit termDeposit = new TermDeposit(initialDepositAmount, interestRate, investmentTerm, frequency);

            CalculateService service = new CalculateService();
            double finalBalance = service.calculateFinalBalance(termDeposit);

            System.out.println("finalBalance = " + finalBalance + " on the initial amount = " + initialDepositAmount
                               + " and interest rate = " + interestRate
                               + " with " + investmentTerm
                               + " year(s) investment term paid " + frequency);
        } catch (Exception e) {
            System.out.println("err: " + e.getMessage());
        }
    }
}