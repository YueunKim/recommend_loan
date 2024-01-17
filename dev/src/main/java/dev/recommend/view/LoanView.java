package dev.recommend.view;

import java.util.List;

import com.loan.dto.LoanProductDto;

import dev.recommend.model.LoanProduct;


// Todo 결과에 대한 출력용 역할을 담당하는 클래스
public class LoanView {
	
	// 1. 전체 조회 결과를 포매팅
	public void findAll(List<LoanProductDto> loanProduct) {
		for (LoanProductDto product : loanProduct) {
            System.out.println(String.format("대출상품 %s의 대출한도는 %d이고 최소신용등급은 %s 입니다.", product.getName(), product.getLoanLimit(), product.getMinimumCreditGrade()));

        }
	}
	
	// 등록 처리 여부 결과 출력
    public void save() {
        System.out.println("정상 등록 되었습니다.");
    }

    // 에러 결과 출력
    public void errorPage(Exception error) {
        System.out.println("문제가 발생하였습니다." + error.getMessage());
    }
    
    public void update(int affectedRows) {
        System.out.println(affectedRows + "개의 행(row)이 수정되었습니다. ");
    }

    public void delete(int affectedRows) {
        System.out.println(affectedRows + "개의 행(row)이 삭제되었습니다. ");
    }
}