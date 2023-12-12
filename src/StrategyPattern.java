// Interfața pentru strategie
interface PaymentStrategy {
    void pay(int amount);
}

// Implementări concrete ale strategiei
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(name + " paid " + amount + " using credit card  " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String name;

    public PayPalPayment(String email, String name) {
        this.email = email;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(name + " paid " + amount + " using PayPal account: " + email);
    }
}

// Clasa care utilizează o strategie
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Exemplu de utilizare a Strategy Pattern
public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Setăm o strategie de plată cu cardul de credit
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432", "Florinel Coman"));
        cart.checkout(100);

        // Schimbăm strategia de plată cu PayPal
        cart.setPaymentStrategy(new PayPalPayment("florinel.coman@becali.com", "Florinel Coman"));
        cart.checkout(50);
    }
}

