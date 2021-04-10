package com.java.freeboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
		컨트롤러는 대문급이다.
		1. 컨트롤러에서 예외처리를 못하는 경우
		2. 대문이 더러우면 안된다. 모든 처리는 서비스?
*/
/**
 * Handles requests for the application home page.
 */
@Controller
/*
 * 어노테이션은 주석일까 아닐까 => 주석이다.
 * 스프링이 무시하지 않는 주석임.
 */
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// Logger를 불러오는 수식
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	/* 	★★★ 요청을 받을 때 get방식 Post방식을 결정한다.
		 @RequestMapping(value = "/", method = RequestMethod.GET)
		 RequestMapping - Value에 어떤 값을 입력할 경우 / 아래있는 것이 실행이 된다.
	*/
	public String home(Locale locale, Model model) {
		// ★★★ Model - 담아주는 주머니 역할, Key와 값으로 구분이 되는데 ("ServerTime"-키, formattedDate-값)
		// 이거를 Model단에 담겨져있는 것을 다 꺼낼 수 있음.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// Return값으로 home을 가르킨다. home.jsp파일(View파일)
		// WEB-INF/spring/appServlet/servlet-context.xml파일아래 정의되어 있다.
	}
	
}
