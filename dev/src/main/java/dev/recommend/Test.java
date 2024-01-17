package dev.recommend;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@NoArgsConstructor // 인수 없는 기본 생성자
@AllArgsConstructor
@ToString

public class Test {
	private int id;
	private String title;
	private String description;
	private LocalDate dueDate;
	private boolean isCompleted;
	
	
	public Test(String title, String description, LocalDate dueDate, boolean isCompleted) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;
	}
}