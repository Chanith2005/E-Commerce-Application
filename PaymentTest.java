import java.util.*;
import java.util.ArrayList;

public class PaymentTest {
    public static void main(String[] args) {
        System.out.println("--- 🛒 Payment Module Test Start ---");


        Payment cod = new CashOnDelivery(5000, "LKR", "PENDING", "COD-1", "Colombo");

        Payment cod2 = new CashOnDelivery(14000, "LKR", "PENDING", "COD-2", "Anuradapura");

        Payment bank = new BankTransfer(15000, "LKR", "PENDING", "BT-1", "BOC", "1234567890");

        CreditCardPayment credit = new CreditCardPayment(15000.00, "LKR", "PENDING", "CC-1", "4111-...", "Chanith", "12/28", 50000.00);

        DebitCardPayment debit = new DebitCardPayment(8000.00, "LKR", "PENDING" , "DC-1", "4222-...", "Perera", "10/27", 12000.00);

        List<Payment> payments = new ArrayList<>();
        payments.add(cod);
        payments.add(cod2);
        payments.add(bank);
        payments.add(credit);
        payments.add(debit);

        for (Payment payment : payments) {
            System.out.println("\n=============================================");
            System.out.println(" (Reference Id: " + payment.getReference() + ")");

            System.out.println("  1. Validation Check: " + payment.validate());

            if (payment instanceof Discount) {
                Discount discountable = (Discount) payment;

                discountable.applyDiscount(5);
                System.out.println("  2. Initial Amount: " + payment.getAmount() + " LKR");
                System.out.println("  3. Final Payable: " + discountable.finalAmount() + " LKR");
            }


            payment.processPayment();

            System.out.println(payment.generateReceipt());
        }
    }
}
