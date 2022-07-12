package com.message.to.future.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.message.to.future.dto.UserDTO;

@Entity
@Table(name = "tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<MessageEntity> messages = new HashSet<>();

	public UserEntity() {
		super();
	}

	public UserEntity(UserDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.phone = dto.getPhone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<MessageEntity> getMessages() {
		return messages;
	}

	public void setMessages(Set<MessageEntity> messages) {
		this.messages = messages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserEntity)) {
			return false;
		}
		UserEntity other = (UserEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", nome=" + name + ", email=" + email + ", phone=" + phone + ", messages="
				+ messages + "]";
	}

}
