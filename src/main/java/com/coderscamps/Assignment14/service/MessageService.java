package com.coderscamps.Assignment14.service;

import com.coderscamps.Assignment14.domain.Message;
import com.coderscamps.Assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);

    }


}
