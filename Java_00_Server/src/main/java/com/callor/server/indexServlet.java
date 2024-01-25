package com.callor.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet : Server Applet Java 코드를 사용하는 Server 어플리케이션 클래스 HttpServlet 클래스를
 * 상속받고, @WebServlet Annotation 을 부착한다 doGet(), doPost() method 를 기본적으로 구현한다
 */
@WebServlet( "/index" )
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public indexServlet() {
		super();
	}

	// router.get("/",(req,res)=>{}) 자바는 req,res 받는데 타입이 필요함 - HttpServletRequest
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// res.send, 화면에 쓸수있는 도구가져와서 저 문자열추가시켜, 그리고 사용자가 요청한 contextpath도 보여조
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String view = "/WEB-INF/views/index.jsp";
		// dispatcher()로 view 를 만들고
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		// forward=render 해라
		dispatcher.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
