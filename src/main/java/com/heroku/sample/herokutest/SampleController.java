package com.heroku.sample.herokutest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

	@Value("${welcome.message}")
	private String message;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String sayHai(Map<String, Object> model) {
		model.put("message", message);
		return "home";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(Map<String, Object> model) {
//		model.put("message", message);
		return "hello";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage(Map<String, Object> model) {
//		model.put("message", message);
		return "error";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Map<String, Object> model) {
//		model.put("message", message);
		return "login";
	}
}
