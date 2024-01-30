package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.model.StudentDto;
import com.callor.hello.service.StudentService;

@Controller
public class HomeController {
	// 스프링아 studentService bean이 있으면 나한테 줘, 근데 없어서 오류생김
	/*
	 * Spring Project 에서 가장 많이 보이는 error 메세지
	 * No qualifying bean of type 'com.callor.hello.service.StudentService'
	 * 
	 * HomeController 에서 StudentService 클래스로 만들어진 bean(객체, 컴포넌트)를
	 * 사용하겠다고 Spring 에게 달라고 요청했다.
	 * 
	 * 근데 어떤 이유로 StudnetService 클래스의 bean이 생성이 안되었을때 
	 * 보여지는 error 메세지이다
	 * 
	 * 이 메세지의 대부분의 원인은 bean 을 생성할 클래스에 
	 * @Annotation 이 누락된 경우이다.
	 * 
	 * servlet-context.xml 에서 스캔을 controller 만 했기 때문에 
	 * service package도 추가해줘야 한다.
	 */
	private final StudentService studentService;
	public HomeController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		StudentDto stDto = studentService.getStudent();		
		return "home";
	}
	



}
