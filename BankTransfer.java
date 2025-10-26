public class BankTransfer extends Payment{

    private String bankName;
    private String accountNumber;
    private String referenceCode;

    public BankTransfer(double amount, String currency, String status, String bankName, String accountNumber, String referenceCode) {
        super(amount, currency, status);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.referenceCode = referenceCode;
    }

    @Override
    public void processPayment() {
        System.out.println("Initialising bank transfer to : "+this.bankName+", using account : "+this.accountNumber+", with reference code: "+ this.referenceCode);
        this.markAsCompleted();
    }

}
