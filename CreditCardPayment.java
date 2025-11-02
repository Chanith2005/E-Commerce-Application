public class CreditCardPayment extends CardPayment implements Discount{
    private double creditLimit;
    private double priceAfterDiscount;

    public CreditCardPayment(double amount, String currency, String status, String referenceId, String cardNumber, String cardHolderName, String expiryDate, double creditLimit) {
        super(amount, currency, status, referenceId, cardNumber, cardHolderName, expiryDate);
        this.creditLimit = creditLimit;

    }

    @Override
    public void processPayment() {
        System.out.println("Charging credit card with limit: " + this.creditLimit + ", for amount: "+ this.getAmount());
        markAsCompleted();
    }

    @Override
    public double applyDiscount(double percent) {
        if (this.getAmount() > 10000) {
            this.priceAfterDiscount = this.getAmount() * (1 - (percent/100));
            return this.priceAfterDiscount;
        }
        else {
            return this.getAmount();
        }

    }

    @Override
    public double finalAmount() {
        return this.priceAfterDiscount;
    }

    public void applyInterest() {
        System.out.println("Applying interest if payment is not settled by due date");
    }
}
