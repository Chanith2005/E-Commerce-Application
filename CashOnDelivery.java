public class CashOnDelivery extends Payment{
    private String deliveryAddress;

    public CashOnDelivery() {}

    public CashOnDelivery(double amount, String currency, String status, String referenceId, String deliveryAddress) {
        super(amount, currency, status, referenceId);
        this.deliveryAddress = deliveryAddress;
    }


    @Override
    public boolean validate() {
        if (this.getAmount() <= 13000) {
            System.out.println("CoD validated");
            return true;
        }
        else {
            System.out.println("CoD validation failed");
            return false;
        }
    }

    @Override
    public void processPayment() {
        if (this.validate()) {
            System.out.println("Cash will be collected at delivery address : "+ this.deliveryAddress);
            this.markAsCompleted();
        }
        else {
            System.out.println("CoD cannot be done due to amount being too high");
        }

    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
