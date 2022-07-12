package com.message.to.future.repository;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.message.to.future.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

	Set<MessageEntity> findMessagesBySendDate(LocalDate now);

}
