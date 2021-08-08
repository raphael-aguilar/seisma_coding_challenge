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

    public boolean isEquals(Price other) {
        return (this.dollars == other.dollars && this.cents == other.cents);
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

    public void addCents(int cents) {
        this.cents += cents;
        this.balance();
    }

    public void plus(Price price) {
        this.dollars += price.dollars;
        this.cents += price.cents;

        this.balance();
    }

    public String getDollarsRounded() {
        if (this.cents >= 50) {
            return Integer.toString (this.dollars + 1);
        } else {
            return Integer.toString((this.dollars));
        }
    }
}
