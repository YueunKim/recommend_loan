package dev.recommend;

import com.loan.dto.LoanProductDto;

import dev.recommend.controller.LoanController;

public class App {

	public static void main(String[] args) {
		
		LoanController controller = new LoanController();
		controller.findAll();
		
		controller.findById(3L);
		
		controller.updateLoan(new LoanProductDto(1L, "test1", 112001, 1.7F, "D")); // 상품 입력 데이터 넘겨주기

	}

}
