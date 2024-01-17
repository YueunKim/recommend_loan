package dev.recommend.controller;

import java.util.List;

import com.loan.dto.LoanProductDto;

import dev.recommend.dao.LoanDAO;
import dev.recommend.view.LoanView;

public class LoanController {
		public void findAll() {
			// db에서 todo 데이터 조회
			LoanDAO loanDAO = new LoanDAO();
			List<LoanProductDto> loanProduct = loanDAO.findAll();
//			System.out.println(loanProduct);
			LoanView loanView = new LoanView();
			// 결과 데이터 포맷팅, 출력
			loanView.findAll(loanProduct);
		}
		
		public void createLoanProduct() {
			LoanDAO loanDAO = new LoanDAO();
			loanDAO.createLoanProduct("wow",5000,6.5f,"E");

		}
		
		public void recommend() {
			LoanDAO loanDAO = new LoanDAO();
			System.out.println(loanDAO.recommend("A",10));

		}
}
