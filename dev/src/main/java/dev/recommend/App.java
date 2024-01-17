package dev.recommend;

import dev.recommend.controller.LoanController;

public class App {

	public static void main(String[] args) {
		
		LoanController controller = new LoanController();
		controller.findAll();
		controller.createLoanProduct();
		controller.recommend();
	}
}
