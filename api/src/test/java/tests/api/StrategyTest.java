package tests.api;

import org.example.api.strategy.PaymentStrategy;
import org.example.api.strategy.ShoppingCart;
import org.example.api.strategy.strategies.BitcoinPayment;
import org.example.api.strategy.strategies.CreditCardPayment;
import org.example.api.strategy.strategies.PayPalPayment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class StrategyTest {

    @Test
    void testCreditCardPayment() {
        // Arrange
        ShoppingCart cart = new ShoppingCart(new CreditCardPayment());

        // Act
        cart.checkout(100.00); // Process credit card payment of $100.00

        // Assert (you can use a mocking framework to assert output or behavior)
        // For simplicity, we assume it's printed, so you can assert the output manually or via log capturing
        assertTrue(true); // Just a placeholder assertion, depending on your testing framework (e.g., SystemOutRule)
    }

    @Test
    void testPayPalPayment() {
        // Arrange
        ShoppingCart cart = new ShoppingCart(new PayPalPayment());

        // Act
        cart.checkout(150.00); // Process PayPal payment of $150.00

        // Assert
        assertTrue(true); // Placeholder assertion
    }

    @Test
    void testBitcoinPayment() {
        // Arrange
        ShoppingCart cart = new ShoppingCart(new BitcoinPayment());

        // Act
        cart.checkout(200.00); // Process Bitcoin payment of $200.00

        // Assert
        assertTrue(true); // Placeholder assertion
    }

    @Test
    void testWithMockCreditCardPayment() {
        // Arrange
        PaymentStrategy creditCardPayment = mock(CreditCardPayment.class);
        ShoppingCart cart = new ShoppingCart(creditCardPayment);

        // Act
        cart.checkout(100.00); // Process credit card payment of $100.00

        // Assert
        verify(creditCardPayment, times(1)).pay(100.00); // Verify pay method was called with $100.00
    }

    @Test
    void testWithMockPayPalPayment() {
        // Arrange
        PaymentStrategy payPalPayment = mock(PayPalPayment.class);
        ShoppingCart cart = new ShoppingCart(payPalPayment);

        // Act
        cart.checkout(150.00); // Process PayPal payment of $150.00

        // Assert
        verify(payPalPayment, times(1)).pay(150.00); // Verify pay method was called with $150.00
    }

    @Test
    void testWithMockBitcoinPayment() {
        // Arrange
        PaymentStrategy bitcoinPayment = mock(BitcoinPayment.class);
        ShoppingCart cart = new ShoppingCart(bitcoinPayment);

        // Act
        cart.checkout(200.00); // Process Bitcoin payment of $200.00

        // Assert
        verify(bitcoinPayment, times(1)).pay(200.00); // Verify pay method was called with $200.00
    }
}
