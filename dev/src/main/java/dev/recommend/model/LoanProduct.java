package dev.recommend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.loan.dto.LoanProductDto;

@Getter
@Setter
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 인수로 받는 생성자
@ToString
public class LoanProduct  {
	private long id; 
	private String name; // 상품명
	private int limit; // 대출 한도 가격
	private float interest_rate; // 이자율
	private long credit_grade_id; // 최소 대출 등급
	
	public LoanProduct(String name, int limit, float interest_rate,
			long credit_grade_id) {
		super();
		this.name = name;
		this.limit = limit;
		this.interest_rate = interest_rate;
		this.credit_grade_id = credit_grade_id;
	}
	
	
	
}
