package com.abc.hi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/svc/hi/v1")
public class HiController {

	@Autowired
	private RestTemplate restTemplate;

	public HiController(RestTemplate restTemplate) {
		super();
		this.restTemplate= restTemplate;
	}

	@GetMapping("/hi")
	public String hiWorld() {
		String response = restTemplate.getForObject("http://localhost:8089/svc/hello/v1/hello", String.class);
		return "hiWorld--->" + response;
	}
}
