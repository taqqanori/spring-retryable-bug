package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.NonRetryableService;
import com.example.demo.service.RetryableService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DemoApplicationController {

	@Autowired
	private RetryableService retryableService;

	@Autowired
	private NonRetryableService nonRetryableService;

	@RequestMapping("/**")
	public ResponseEntity<String> handle(String body, HttpMethod method, HttpServletRequest request,
			HttpServletResponse response) {

		retryableService._final();
		retryableService.nonFinal();
		nonRetryableService._final();
		nonRetryableService.nonFinal();

		return ResponseEntity.ok("ok: see the log!");
	}

}
