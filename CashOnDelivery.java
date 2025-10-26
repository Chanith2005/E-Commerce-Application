public class CashOnDelivery extends Payment{
    private String deliveryAddress;

    public CashOnDelivery() {}

    public CashOnDelivery(double amount, String currency, String status, String deliveryAddress) {
        super(amount, currency, status);
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public void processPayment() {
        System.out.println("Cash will be collected at delivery address : "+ this.deliveryAddress);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
