package com.codingwithpro.sqsconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class SQSStarter {
	
	@Autowired
	private SQSConsumer sqsListener;
	
	@PostConstruct
	public void init() {
		sqsListener.processQueue();
	}
}
