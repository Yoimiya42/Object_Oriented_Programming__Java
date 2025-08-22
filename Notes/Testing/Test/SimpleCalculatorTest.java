package Testing.Test;

import Testing.SimpleCalculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

	private SimpleCalculator calculator;

	@BeforeEach
	// Refactor to integrate the arrangements
	public void setUp(){
		calculator = new SimpleCalculator();
	}

	@Test
	public void depositing_a_value_to_zero_should_give_that_value(){
//		SimpleCalculator calculator = new SimpleCalculator(); //Arrange
		calculator.deposit(42); // Act
		assertEquals(42, calculator.getBalance(), "42 added to 0 should return 42."); // Assert
	}

	@Test
	public void withdrawing_a_value_to_zero_should_give_that_value(){
//		SimpleCalculator calculator = new SimpleCalculator();
		calculator.withdraw(7);
		assertEquals(-7, calculator.getBalance());
	}
}