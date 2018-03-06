package com.java.serviceone.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class Hello {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/post")
	public String get(){
		return "from service one";
	}
	

    @HystrixCommand(fallbackMethod = "backtrace")
	@RequestMapping("/get")
	public String call(){
		return restTemplate.getForObject("http://service-two/post", String.class);
	}
    
    public String backtrace() {
        return "Error while calling http://service-two/post service ";
    }
}
