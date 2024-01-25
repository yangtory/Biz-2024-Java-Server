package com.callor.hello.models;

public class StudentDto {
	// Spring Project 에서는 Dto 클래스의 속성(변수, 멤버)는 
	// private 으로 선언한다.
	private String stNum;
	private String stName;
	private String stGrade;
	
	public StudentDto() {
	
	}
	
	public StudentDto(String stNum, String stName, String stGrade) {
		super();
		this.stNum = stNum;
		this.stName = stName;
		this.stGrade = stGrade;
	}

	// 한 쌍의 겟,셋 만들어야댐 이렇게 해야 private 인친구들을 쓸수 있음 (정보의 은닉)
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStGrade() {
		return stGrade;
	}
	public void setStGrade(String stGrade) {
		this.stGrade = stGrade;
	}
	
	@Override
	public String toString() {
		return "StudentDto [stNum=" + stNum + ", stName=" + stName + ", stGrade=" + stGrade + "]";
	}
	
}
