package org.example.api.strategy.strategies;

import org.example.api.strategy.PaymentStrategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        // Logic to process payment via PayPal
    }
}
