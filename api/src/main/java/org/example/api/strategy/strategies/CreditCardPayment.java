package org.example.api.strategy.strategies;

import org.example.api.strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Logic to process payment via credit card
    }
}
