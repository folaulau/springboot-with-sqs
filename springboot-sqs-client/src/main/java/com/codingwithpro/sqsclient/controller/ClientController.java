package com.codingwithpro.sqsclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingwithpro.sqsclient.model.QueueMessage;
import com.codingwithpro.sqsclient.service.QueueSenderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Client", description = "Client Operations")
@Slf4j
@RestController
public class ClientController {
    
    @Autowired
    private QueueSenderService queueSenderService;

    @Operation(summary = "Send Message to Queue")
    @PostMapping("/send-message")
    public ResponseEntity<Boolean> sendMessage(@RequestBody QueueMessage queueMessage) {
        log.info("sendMessage {}", queueMessage.toString());
        return new ResponseEntity<>(queueSenderService.sendQueueMessage(queueMessage), HttpStatus.OK);
    }
}
