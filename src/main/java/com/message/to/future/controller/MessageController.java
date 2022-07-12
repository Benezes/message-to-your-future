package com.message.to.future.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.message.to.future.dto.MessageDTO;
import com.message.to.future.service.MessageService;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(messageService.postMessage(messageDTO));
	}

	@GetMapping
	public ResponseEntity<List<MessageDTO>> getMessage() {
		return ResponseEntity.ok(messageService.findAllMessages());
	}
}
