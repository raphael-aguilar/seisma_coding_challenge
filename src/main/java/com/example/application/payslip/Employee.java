package com.example.application.payslip;

import org.json.simple.*;

public class Employee {

    private String firstName;
    private String lastName;
    private int annualSalary;
    private double superRate;
    private String paymentPeriod;


    private Price grossIncome;
    private Price yearlyIncomeTax;
    private Price monthlyIncomeTax;
    private Price netIncome;
    private Price superVal;

    public Employee(String firstName, String lastName, int annualSalary, double superRate, String paymentPeriod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.paymentPeriod = paymentPeriod;
    }

    public void calculateValues() {
        this.yearlyIncomeTax = TaxCalculator.calculateTax(annualSalary);
        this.monthlyIncomeTax = new Price((int) Math.round(yearlyIncomeTax.getDollars()/12d), 0);
        this.grossIncome = IncomeCalculator.calculateIncome(annualSalary);
        this.netIncome = grossIncome.subtract(monthlyIncomeTax);
        this.superVal = new Price((int) ((superRate / 100) * grossIncome.getDollars()), 0);
    }

    public String toOutputLine() {

        String[] data = new String[6];

        data[0] = firstName + " " + lastName;
        data[1] = paymentPeriod;
        data[2] = Integer.toString(grossIncome.getDollars());
        data[3] = Integer.toString(monthlyIncomeTax.getDollarsRounded());
        data[4] = Integer.toString(netIncome.getDollars());
        data[5] = Integer.toString(superVal.getDollars());


        return String.join(",", data);
    }

    public JSONObject toJson() {
        JSONObject output = new JSONObject();

        output.put("Name", firstName + " " + lastName);
        output.put("Pay Period", paymentPeriod);
        output.put("Gross Income", Integer.toString(grossIncome.getDollars()));
        output.put("Income Tax", Integer.toString(monthlyIncomeTax.getDollarsRounded()));
        output.put("Net Income", Integer.toString(netIncome.getDollars()));
        output.put("Super", Integer.toString(superVal.getDollars()));

        return output;
    }
}
