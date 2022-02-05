package com.coderscamps.Assignment14.repository;

import com.coderscamps.Assignment14.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
