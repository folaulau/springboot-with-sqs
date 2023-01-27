package com.codingwithpro.sqsclient.service;

import com.codingwithpro.sqsclient.model.QueueMessage;

public interface QueueSenderService {

    boolean sendQueueMessage(QueueMessage queueMessage);
}
