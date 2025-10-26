public class Payment {

    private double amount;
    private String currency;
    private String status;

    public Payment() {}

    public Payment(double amount, String currency, String status) {
        this.amount = amount;
        this.currency = currency;
        this.status = status;
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

    public void processPayment() {
        System.out.println("Processing generic payment");
    }

    public String generateReceipt() {
        return "Receipt for amount : " + this.amount + ", currency : " + this.currency;
    }

    public String markAsCompleted() {
        this.status = "COMPLETED";
        return this.status;
    }
}
