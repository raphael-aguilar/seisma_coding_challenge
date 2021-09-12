package com.application.payslip;

public class Price {

    private int dollars;
    private int cents;

    public Price()  {
        this.dollars = 0;
        this.cents = 0;
    }

    public Price(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Price(Price other) {
        this.dollars = other.getDollars();
        this.cents = other.getCents();
    }

    public boolean isEqual(Price other) {
        return (this.dollars == other.dollars && this.cents == other.cents);
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public String toString() {
        return this.dollars + "." + String.format("%02d", this.cents);
    }

//    Converts any overflowed cents to dollars
    private void balance() {
        this.dollars += cents/100;
        this.cents %= 100;
    }

    public void addDollars(int dollars) {
        this.dollars += dollars;
    }

    public void subtractDollars(int dollars) {
        this.dollars -= dollars;
    }

    public void addCents(int cents) {
        this.cents += cents;
        this.balance();
    }

    public void subtractCents(int cents) {
        this.cents -= cents;
        if (this.cents < 0) {
            this.subtractDollars(1);
            this.addCents(100);
        }
    }

    public Price plus(Price price) {
        Price output = new Price(this);

        output.addDollars(price.getDollars());
        output.addCents(price.getCents());
        output.balance();

        return output;
    }

    public Price subtract(Price other) {
        Price output = new Price(this);
        output.subtractDollars(other.getDollars());
        output.subtractCents(other.getCents());
        return output;

    }

    public int getDollarsRounded() {
        if (this.cents >= 50) {
            return this.dollars + 1;
        } else {
            return this.dollars;
        }
    }
}
