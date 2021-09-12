package com.application.payslip;

import com.application.payslip.Price;
import com.application.payslip.TaxCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void calculateTax() {

        Price test1 = new Price(0, 0);
        Price test2 = new Price(54232, 45);
        Price test3 = new Price(0, 76);
        Price test4 = new Price(54232, 0);

        assertAll(
                () -> assertTrue(test1.isEqual(TaxCalculator.calculateTax(18000))),
                () -> assertTrue(test2.isEqual(TaxCalculator.calculateTax(180001))),
                () -> assertTrue(test3.isEqual(TaxCalculator.calculateTax(18204))),
                () -> assertTrue(test4.isEqual(TaxCalculator.calculateTax(180000)))
        );
    }
}