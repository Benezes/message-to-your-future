package com.message.to.future.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.to.future.dto.MessageDTO;
import com.message.to.future.entity.UserEntity;
import com.message.to.future.repository.MessageRepository;
import com.message.to.future.repository.UserRepository;
import com.message.to.future.service.factory.MessageFactory;
import com.message.to.future.service.factory.UserFactory;

@Service
public class MessageService {

	@Autowired
	private UserFactory userFactory;
	@Autowired
	private MessageFactory messageFactory;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UserRepository userRepository;

	public String postMessage(MessageDTO messageDTO) {
		UserEntity user = userRepository.save(userFactory.createUser(messageDTO));
		messageRepository.save(messageFactory.createMessage(messageDTO, user));
		return "MESSAGE POST";
	}

	public List<MessageDTO> findAllMessages() {
		return messageRepository.findAll().stream().map(MessageDTO::new).collect(Collectors.toList());
	}

}
