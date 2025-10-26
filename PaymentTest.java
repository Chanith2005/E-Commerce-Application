import java.util.*;
import java.util.ArrayList;

public class PaymentTest {
    public static void main(String[] args) {
        Payment cod = new CashOnDelivery(5000, "LKR", "PENDING","Colombo");
        Payment bank = new BankTransfer(15000, "LKR", "COMPLETED" , "BOC", "123456789", "REF123");
        Payment credit = new CreditCardPayment(10000, "LKR", "COMPLETED", "4111111111111111", "Chanith ", "12/28", 50000);
        Payment debit = new DebitCardPayment(8000, "LKR", "COMPLETED" , "4222222222222", "Perera", "10/27", 25000);

        List<Payment> payments = new ArrayList<>();
        payments.add(cod);
        payments.add(bank);
        payments.add(credit);
        payments.add(debit);

        for (Payment payment : payments) {
            payment.processPayment();
            payment.generateReceipt();
            System.out.println();
        }
    }
}
