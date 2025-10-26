public class CreditCardPayment extends CardPayment {
    private double creditLimit;

    public CreditCardPayment(double amount, String currency, String status, String cardNumber, String cardHolderName, String expiryDate, double creditLimit) {
        super(amount, currency, status, cardNumber, cardHolderName, expiryDate);
        this.creditLimit = creditLimit;
    }

    @Override
    public void processPayment() {
        System.out.println("Charging credit card with limit: " + this.creditLimit + ", for amount: "+ this.getAmount());
        markAsCompleted();
    }

    public void applyInterest() {
        System.out.println("Applying interest if payment is not settled by due date");
    }
}
