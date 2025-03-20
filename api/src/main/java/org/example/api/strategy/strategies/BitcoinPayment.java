package org.example.api.strategy.strategies;

import org.example.api.strategy.PaymentStrategy;

public class BitcoinPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Bitcoin payment of $" + amount);
        // Logic to process payment via Bitcoin
    }
}
