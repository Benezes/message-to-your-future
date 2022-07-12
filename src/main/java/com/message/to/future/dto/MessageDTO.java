package com.message.to.future.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.message.to.future.entity.MessageEntity;

public class MessageDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore(value = true)
	private Long id;
	private String text;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate sendDate;
	private UserDTO user = new UserDTO();

	public MessageDTO() {
		super();
	}

	public MessageDTO(MessageEntity entity) {
		this.text = entity.getText();
		this.sendDate = entity.getSendDate();
		user.setName(entity.getUser().getName());
		user.setEmail(entity.getUser().getEmail());
		user.setPhone(entity.getUser().getPhone());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
