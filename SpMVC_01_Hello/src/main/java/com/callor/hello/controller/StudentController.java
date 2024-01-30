package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.hello.model.StudentDto;

@Controller
@RequestMapping(value="/student") // 중복된 /student 없애고싶음
public class StudentController {
	
	// String.format 으로 return 하기
	private String viewURL = "student/%s";
	/*
	 * "/student/" 또는 "/student" 로 요청이 되면
	 * 첫번째 router 가 "/student/" 로만 보냄
	 * 그래서 value={"/",""}로 바꿔주기 : 끝에 / 있거나 없을때 
	 */
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String list() {
		return String.format(viewURL, "list");
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		return String.format(viewURL, "input");
	}
	
	/*
	 * form 의 input box 에 입력된 데이터(문자열)은 controller method 의 매개변수와
	 * 1:1 로 매칭된다.
	 * 이 때 input box 의 name 속성은 Dto 클래스의 변수명과 일치해야 한다.
	 * 스프링이 setter 를 이용해 값을 사용한다. setter가 필요한 이유
	 * 
	 * @ResponseBody
	 * method 문자열을 return 하면 원래는 views/*.jsp 파일을 찾아서 rendering 한 후
	 * client 로 보낸다. 하지만 @ResponseBody 가 설정되면,
	 *  문자열을 Http 프로토콜의 Response 영역에 그대로 실어서 client 로 보낸다.
	 */
	@ResponseBody 
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	// @ModelAttribute 호환성을 위해 붙힘
	public String insert(@ModelAttribute StudentDto stDto) { // 매개변수 dto에 내용을 담아, dto와 input name 이름이같으면 스프링이 알아서함
		System.out.println(stDto.toString());
		return stDto.toString(); //router에서 문자열을 return 하면
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update() {
		return String.format(viewURL, "update");
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(StudentDto stDto) {
		return "redirect:/detail";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(String stNum) {
		return String.format(viewURL, "detail");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete() {
		// "/student" URL 로 화면을 전환하라
		return "redirect:/student"; 
	}
}
