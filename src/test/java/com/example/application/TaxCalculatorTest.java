package com.application.payslip;

import example.application.payslip.Price;
import example.application.payslip.TaxCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void calculateTax() {

        Price test1 = new Price(0, 0);
        Price test2 = new Price(54232, 45);
        Price test3 = new Price(0, 76);
        Price test4 = new Price(54232, 0);
        Price test5 = new Price(3572, 32);
        Price test6 = new Price(19822, 37);

        assertEquals(test1.toString(), TaxCalculator.calculateTax(18000).toString());
        assertEquals(test2.toString(), TaxCalculator.calculateTax(180001).toString());
        assertEquals(test3.toString(), TaxCalculator.calculateTax(18204).toString());
        assertEquals(test4.toString(), TaxCalculator.calculateTax(180000).toString());
        assertEquals(test5.toString(), TaxCalculator.calculateTax(37001).toString());
        assertEquals(test6.toString(), TaxCalculator.calculateTax(87001).toString());
    }
}