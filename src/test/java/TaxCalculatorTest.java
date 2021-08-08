import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {

    @Test
    void calculateTax() {

        Price test1 = new Price(0, 0);
        Price test2 = new Price(54232, 45);
        Price test3 = new Price(0, 76);

        assertAll(
                () -> assertTrue(test1.isEquals(TaxCalculator.calculateTax(18000))),
                () -> assertTrue(test2.isEquals(TaxCalculator.calculateTax(180001))),
                () -> assertTrue(test3.isEquals(TaxCalculator.calculateTax(18204)))
        );
    }
}