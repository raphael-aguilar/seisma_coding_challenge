package com.example.application;

import com.example.application.payslip.IncomeCalculator;
import com.example.application.payslip.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeCalculatorTest {

    @Test
    void calculateIncome() {

        assertAll(
                () -> assertTrue(new Price(5004, 0).isEqual(IncomeCalculator.calculateIncome(60050))),
                () -> assertTrue(new Price(1200, 0).isEqual(IncomeCalculator.calculateIncome(14400)))
        );
    }
}