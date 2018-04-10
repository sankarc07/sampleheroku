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

	@RequestMapping(value = "/hai", method = RequestMethod.GET)
	public String sayHai(Map<String, Object> model) {
		model.put("message", message);
		return "userdetails";
	}
}
