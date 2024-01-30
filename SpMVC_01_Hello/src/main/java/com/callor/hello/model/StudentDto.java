package com.callor.hello.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //매개변수 없는 생성자
@AllArgsConstructor // 매개변수가 있는 생성자
@Getter
@Setter
@ToString
@Builder // ??
public class StudentDto {
	private String stNum;
	private String stName;
	private String stDept;
	private String stGrade;
	private String stTel;
	private String stAddr;
}
