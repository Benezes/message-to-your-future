package com.message.to.future.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore(value = true)
	private Long id;
	private String name;
	private String email;
	private String phone;
	@JsonIgnore(value = true)
	private Set<MessageDTO> messages = new HashSet<>();

	public UserDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(Set<MessageDTO> messages) {
		this.messages = messages;
	}

}
