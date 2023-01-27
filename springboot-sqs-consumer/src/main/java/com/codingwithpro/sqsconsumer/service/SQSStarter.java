package com.codingwithpro.sqsconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SQSStarter {
	
	@Autowired
	private SQSConsumer sqsListener;
	
	@PostConstruct
	public void init() {
		try {
			sqsListener.processQueue();
		} catch (Exception e) {
			log.warn("Exception, msg={}",e.getLocalizedMessage());
		}
		
	}
}
