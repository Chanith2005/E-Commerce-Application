public class BankTransfer extends Payment{

    private String bankName;
    private String accountNumber;


    public BankTransfer(double amount, String currency, String status, String referenceId, String bankName, String accountNumber) {
        super(amount, currency, status, referenceId);
        this.bankName = bankName;
        this.accountNumber = accountNumber;

    }

    @Override
    public boolean validate() {
        if (this.accountNumber != null && this.accountNumber.length() > 6) {
            System.out.println("Bank Transfer Successful");
            return true;
        } else {
            System.out.println("Bank Transfer Failed");
            return false;
        }
    }

    @Override
    public void processPayment() {
        if (validate()) {
            System.out.println("Initialising bank transfer to : "+this.bankName+", using account : "+this.accountNumber+", with reference id: "+ this.getReference());
            this.markAsCompleted();
        } else {
            System.out.println("Bank Transfer failed validation.");
        }
    }



}
