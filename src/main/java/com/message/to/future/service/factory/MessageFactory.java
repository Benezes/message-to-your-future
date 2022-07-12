package com.message.to.future.service.factory;

import org.springframework.stereotype.Service;

import com.message.to.future.dto.MessageDTO;
import com.message.to.future.entity.MessageEntity;
import com.message.to.future.entity.UserEntity;

@Service
public class MessageFactory {

	public MessageEntity createMessage(MessageDTO dto, UserEntity user) {
		MessageEntity msg = new MessageEntity(dto);
		msg.setUser(user);
		return msg;
	}

}
