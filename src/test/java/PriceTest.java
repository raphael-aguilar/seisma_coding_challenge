import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @Test
    void testToString() {

        Price test = new Price(10, 50);
        Price test2 = new Price(0, 5);

        assertAll(
            () -> assertEquals("10.50", test.toString()),
            () -> assertEquals("0.05", test2.toString())
        );

    }

    @Test
    void addDollars() {

        Price test = new Price(10, 0);
        test.addDollars(50);

        assertTrue(test.isEqual(new Price(60, 0)));
    }

    @Test
    void addCents() {
        Price test = new Price(10, 50);
        test.addCents(50);

        Price test2 = new Price(0, 40);
        test2.addCents(50);

        assertAll(
                () -> assertTrue(test.isEqual(new Price(11, 0))),
                () -> assertTrue(test2.isEqual(new Price(0, 90)))
        );
    }

    @Test
    void getDollarsRounded() {
        Price test = new Price(1, 30);
        Price test2 = new Price(5, 60);

        assertAll(
                () -> assertEquals(test.getDollarsRounded(), 1),
                () -> assertEquals(test2.getDollarsRounded(), 6)
        );
    }
}