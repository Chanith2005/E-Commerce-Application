public class DebitCardPayment extends CardPayment implements Discount{
    private double availableBalance;
    private double priceAfterDiscount;

    public DebitCardPayment(double amount, String currency, String status, String referenceId, String cardNumber, String cardHolderName, String expiryDate, double availableBalance) {
        super(amount, currency, status, cardNumber, cardHolderName, expiryDate, referenceId);
        this.availableBalance = availableBalance;
    }

    @Override
    public void processPayment() {
        System.out.println("Debiting from account balance: "+ this.availableBalance + ", for amount: "+ this.getAmount());
        markAsCompleted();
    }

    @Override
    public double applyDiscount(double percent) {
        if (this.getAmount() > 10000) {
            this.priceAfterDiscount = this.getAmount() * (1 - (percent/100));
            return this.priceAfterDiscount;
        }
        else {
            this.priceAfterDiscount = this.getAmount();
            return this.priceAfterDiscount;
        }

    }

    @Override
    public double finalAmount() {
        return this.priceAfterDiscount;
    }

    public void checkSufficientBalance() {
        System.out.println("Checking if balance covers amount...");
    }
}
