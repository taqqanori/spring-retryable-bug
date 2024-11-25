package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryableService {

	@Value("${spring.application.name}")
	private String value;

	@Retryable
	public void retryable() {
		// just declared, never called
	}

	public void nonFinal() {
		System.out.println("retryable non-final: " + value);
	}

	public final void _final() {
		System.out.println("retryable final: " + value);
	}

}
