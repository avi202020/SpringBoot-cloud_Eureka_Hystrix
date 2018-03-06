package com.java.servicetwo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Hello {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/post")
	public String get(){
		return "from service two";
	}
	
	@RequestMapping("/get")
	public String call(){
		return restTemplate.getForObject("http://service-one/post", String.class);
	}
}
