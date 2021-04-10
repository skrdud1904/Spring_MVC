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
		��Ʈ�ѷ��� �빮���̴�.
		1. ��Ʈ�ѷ����� ����ó���� ���ϴ� ���
		2. �빮�� ������� �ȵȴ�. ��� ó���� ����?
*/
/**
 * Handles requests for the application home page.
 */
@Controller
/*
 * ������̼��� �ּ��ϱ� �ƴұ� => �ּ��̴�.
 * �������� �������� �ʴ� �ּ���.
 */
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// Logger�� �ҷ����� ����
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	/* 	�ڡڡ� ��û�� ���� �� get��� Post����� �����Ѵ�.
		 @RequestMapping(value = "/", method = RequestMethod.GET)
		 RequestMapping - Value�� � ���� �Է��� ��� / �Ʒ��ִ� ���� ������ �ȴ�.
	*/
	public String home(Locale locale, Model model) {
		// �ڡڡ� Model - ����ִ� �ָӴ� ����, Key�� ������ ������ �Ǵµ� ("ServerTime"-Ű, formattedDate-��)
		// �̰Ÿ� Model�ܿ� ������ִ� ���� �� ���� �� ����.
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		// Return������ home�� ����Ų��. home.jsp����(View����)
		// WEB-INF/spring/appServlet/servlet-context.xml���ϾƷ� ���ǵǾ� �ִ�.
	}
	
}
