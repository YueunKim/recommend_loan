package dev.recommend.view;

import java.util.List;

import com.loan.dto.LoanProductDto;

public class LoanView {
	// 1. 전체 조회 결과를 포매팅
	public void findAll(List<LoanProductDto> loanProductDto) {
		for (LoanProductDto loanProduct : loanProductDto) {
			System.out.println(String.format("%d 번 상품 : %s (한도 : %d$, 이자 : %f, 최소 등급 : %s)", 
					loanProduct.getId(), loanProduct.getName(), loanProduct.getLoanLimit(), loanProduct.getInterestRate(), loanProduct.getMinimumCreditGrade()));
//			System.out.println(loanProduct.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
			System.out.println();
		}
	}
	
	public void findById(LoanProductDto loanProductDto) {
		System.out.println(String.format("%d 번 상품 : %s (한도 : %d$, 이자 : %f, 최소 등급 : %s)", 
				loanProductDto.getId(), loanProductDto.getName(), loanProductDto.getLoanLimit(), loanProductDto.getInterestRate(), loanProductDto.getMinimumCreditGrade()));
//		System.out.println(loanProduct.getDueDate().format(DateTimeFormatter.ofPattern("기한은 yyyy년 MM월 dd일 까지입니다.")));
		System.out.println();
	}
	
	public void update() {
        System.out.println("수정되었습니다. ");
    }
	
	
}
