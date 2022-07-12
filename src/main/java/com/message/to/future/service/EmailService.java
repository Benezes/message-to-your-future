package com.message.to.future.service;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.message.to.future.entity.MessageEntity;
import com.message.to.future.repository.MessageRepository;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	private MessageRepository messageRepository;

	/**
	 * Check if scheduler if there is any email in this current data to send
	 */
	@Scheduled(cron = "${schedule.cron.minute}")
	public void validEmails() {
		Set<MessageEntity> messages = messageRepository.findMessagesBySendDate(LocalDate.now());
		messages.stream().forEach(this::sendEmailMessage);
	}

	/**
	 * Method to send the email using the JavaMailSender bean
	 * 
	 * @param msg
	 */
	public void sendEmailMessage(MessageEntity msg) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(msg.getUser().getEmail());
		message.setSubject("This is your e-mail: " + msg.getUser().getName());
		message.setText(msg.getText());
		this.emailSender.send(message);
	}
}
