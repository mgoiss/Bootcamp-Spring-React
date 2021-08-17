package tests.factory;

import entities.Financing;

public class FinancingFactory {
	
	public static Financing createFinancing(double totalAmount, double income, Integer months) {
		return new Financing(totalAmount, income, months);
	}
}
