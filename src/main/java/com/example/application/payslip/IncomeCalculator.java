package com.example.application.payslip;

public class IncomeCalculator {

    public static Price calculateIncome(int yearlyIncome) {
        return new Price(yearlyIncome/12, 0);
    }
}
