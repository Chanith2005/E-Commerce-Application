public abstract class Payment implements Payable {

    private double amount;
    private String currency;
    private String status;
    private String referenceId;

    public Payment() {}

    public Payment(double amount, String currency, String status, String referenceId) {
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.referenceId = referenceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getReference() {
        return this.referenceId;
    }

    abstract void processPayment();

    public String generateReceipt() {
        return "Receipt for amount : " + this.amount + ", currency : " + this.currency;
    }

    public String markAsCompleted() {
        this.status = "COMPLETED";
        return this.status;
    }
}
