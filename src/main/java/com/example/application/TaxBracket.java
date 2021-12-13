package com.example.application;

public class TaxBracket {

    private int minIncome;
    private int baseTax;
    private double additionalTax;

    public TaxBracket(int minIncome, int baseTax, double additionalTax) {
        this.minIncome = minIncome;
        this.baseTax = baseTax;
        this.additionalTax = additionalTax;
    }

    public int getMinIncome() {
        return minIncome;
    }

    public int getBaseTax() {
        return baseTax;
    }

    public double getAdditionalTax() {
        return additionalTax;
    }
}
