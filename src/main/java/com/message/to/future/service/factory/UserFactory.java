package com.message.to.future.service.factory;

import org.springframework.stereotype.Service;

import com.message.to.future.dto.MessageDTO;
import com.message.to.future.entity.UserEntity;

@Service
public class UserFactory {

	public UserEntity createUser(MessageDTO messageDTO) {
		return new UserEntity(messageDTO.getUser());
	}

}
