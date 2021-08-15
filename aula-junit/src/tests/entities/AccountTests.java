package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {

		// Arrange
		double amount = 200.00;
		double expectdValue = 196.00;
		Account acc = AccountFactory.createEmptyAccount();

		// Act
		acc.deposit(amount);

		// Assert
		Assertions.assertEquals(expectdValue, acc.getBalance());
	}

	@Test
	public void depositShouldDoNotthingWhenNegativeAmount() {

		// Arrange
		double expectdValue = 100.0;
		Account acc = AccountFactory.createAccount(expectdValue);
		double amount = -200.00;

		// Act
		acc.deposit(amount);

		// Assert
		Assertions.assertEquals(expectdValue, acc.getBalance());
	}

	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {

		// Arrange
		double expectdValue = 0;
		double initialBalace = 800.0;
		Account acc = AccountFactory.createAccount(initialBalace);

		// Act
		double result = acc.fullWithdraw();

		// Assert
		Assertions.assertTrue(expectdValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalace);
	}

	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {

		// Arrange
		Account acc = AccountFactory.createAccount(800.0);

		// Act
		acc.withdraw(500.0);

		// Assert
		Assertions.assertEquals(300.0, acc.getBalance());
	}

	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {

		// Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Arrange
			Account acc = AccountFactory.createAccount(800.0);

			// Act
			acc.withdraw(801.0);
		});
	}
}
