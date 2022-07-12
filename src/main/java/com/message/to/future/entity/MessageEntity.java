package com.message.to.future.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.message.to.future.dto.MessageDTO;

@Entity
@Table(name = "tb_message")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String text;
	private LocalDate currentDay = LocalDate.now();
	private LocalDate sendDate;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	public MessageEntity() {
		super();
	}

	public MessageEntity(MessageDTO dto) {
		this.id = dto.getId();
		this.text = dto.getText();
		this.sendDate = dto.getSendDate();
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

	public LocalDate getCurrentDate() {
		return currentDay;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDay = currentDate;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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
		if (!(obj instanceof MessageEntity)) {
			return false;
		}
		MessageEntity other = (MessageEntity) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MessageEntity [id=" + id + ", text=" + text + ", currentDate=" + currentDay + ", sendDate=" + sendDate
				+ ", user=" + user + "]";
	}

}
