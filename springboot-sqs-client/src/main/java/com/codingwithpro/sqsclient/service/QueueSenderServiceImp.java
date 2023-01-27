package com.codingwithpro.sqsclient.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.codingwithpro.sqsclient.model.QueueMessage;
import com.codingwithpro.sqsclient.utils.ObjectMapperUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QueueSenderServiceImp implements QueueSenderService {

	@Autowired
	private AmazonSQS sqs;

	@Autowired
	private String msgQueue;

	@Override
	public boolean sendQueueMessage(QueueMessage queueMessage) {
		queueMessage.setUuid(UUID.randomUUID().toString()+"-"+UUID.randomUUID().toString());
		queueMessage.setNow(new Date());

		log.info("msgQueue={}, queueMessage={}", msgQueue, ObjectMapperUtils.toJson(queueMessage));

		SendMessageRequest send_msg_request = new SendMessageRequest().withQueueUrl(msgQueue)
				.withMessageBody(ObjectMapperUtils.toJson(queueMessage));

		SendMessageResult result =sqs.sendMessage(send_msg_request);
		
		log.info("message id={}",result.getMessageId());

		return true;
	}

}
