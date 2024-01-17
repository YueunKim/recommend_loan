package dev.recommend.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor // 인수 없는 기본 생성자
@AllArgsConstructor
@ToString

public class LoanProduct {
	private long id;
	private String name;
	private int loan_limit;
	private float interest_rate;
	private long credit_grade_id;
	
	
	public LoanProduct(String name, int loan_limit, float interest_rate, long credit_grade_id) {
		this.name = name;
		this.loan_limit = loan_limit;
		this.interest_rate = interest_rate;
		this.credit_grade_id = credit_grade_id;
	}
}