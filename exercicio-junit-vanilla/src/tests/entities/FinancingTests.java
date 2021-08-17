package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void createFinancingCorrect() {

		// Arrange
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;

		// Act
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

		// Assert
		Assertions.assertEquals(totalAmount, financing.getTotalAmount());
		Assertions.assertEquals(income, financing.getIncome());
		Assertions.assertEquals(months, financing.getMonths());
	}

	@Test
	public void createFinancingShouldThrowExceptionWhenValueIncorrect() {

		// Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Arrange e Act
			Financing financing = FinancingFactory.createFinancing(100000.0, 2000.0, 20);

			financing.getTotalAmount();

		});
	}

	@Test
	public void updateValueTotalAmountWhenValidMainData() {

		// Arrange
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		Double otherTotalAmount = 1000.0;
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

		// Act
		financing.setTotalAmount(otherTotalAmount);

		// Assert
		Assertions.assertTrue(otherTotalAmount == financing.getTotalAmount());
	}

	@Test
	public void updateShouldThrowExceptionWhenValueUpdateIncorrect() {

		// Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Arenge
			Financing financing = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

			// Act
			financing.setTotalAmount(200000.0);
		});
	}

	@Test
	public void updateValueIncomeWhenValidMainData() {

		// Arrange
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		double otherIncome = 2500.0;
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

		// Act
		financing.setIncome(otherIncome);

		// Assert
		Assertions.assertTrue(otherIncome == financing.getIncome());
	}

	@Test
	public void updateShouldThrowExceptionWhenValueIncomeUpdateIncorrect() {

		// Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Arange
			Financing financing = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

			// Act
			financing.setIncome(1000.00);
		});

	}

	@Test
	public void updateValueMonthsWhenValidMainData() {

		// Arrange
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		Integer otherMonths = 100;
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

		// Act
		financing.setMonths(otherMonths);

		// Assert
		Assertions.assertTrue(otherMonths == financing.getMonths());
	}

	@Test
	public void updateShouldThrowExceptionWhenValueMonthsUpdateIncorrect() {

		// Assert
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Arange
			Financing financing = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

			// Act
			financing.setMonths(50);
		});
	}

	@Test
	public void correctlyCalculateTheInputValue() {
		// Arrange
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		double expectdValue = 20000.00;
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

		// Act
		double result = financing.entry();

		// Assert
		Assertions.assertTrue(expectdValue == result);
	}

	@Test
	public void correctlyCalculateTheAmountOfTheInstallment() {

		// Arrange
		double totalAmount = 100000.0;
		double income = 2000.0;
		Integer months = 80;
		double expectdValue = 1000.00;
		Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

		// Act
		double result = financing.quota();

		// Assert
		Assertions.assertTrue(expectdValue == result);
	}
}
