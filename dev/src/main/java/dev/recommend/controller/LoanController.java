package dev.recommend.controller;

import java.util.List;

import com.loan.dto.LoanProductDto;

import dev.recommend.dao.LoanDAO;
import dev.recommend.model.LoanProduct;
import dev.recommend.view.LoanView;

public class LoanController {

	public void findAll() {
		
		LoanDAO dao = new LoanDAO();
		LoanView view = new LoanView();
		
		List<LoanProductDto> loanProducts = dao.findAll();
		
//		System.out.println(loanProducts);
		view.findAll(loanProducts);
		
	}
	
	public void updateLoan(LoanProductDto loanProductDto) {
		
		LoanDAO dao = new LoanDAO();
		LoanView view = new LoanView();
		
		dao.updateLoanProduct(loanProductDto.getId(), loanProductDto.getName(), 
				loanProductDto.getLoanLimit(), loanProductDto.getInterestRate(), loanProductDto.getMinimumCreditGrade());
		
		view.update();
		
		
	}

	public void findById(long id) {
		
		LoanDAO dao = new LoanDAO();
		LoanView view = new LoanView();
		
		LoanProductDto dto = dao.findById(id);
		
		System.out.println(dto);
		
//		view.findById(dto);
		
	}

	

}
