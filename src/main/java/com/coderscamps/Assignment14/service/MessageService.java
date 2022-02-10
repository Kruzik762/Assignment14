package com.coderscamps.Assignment14.service;

import com.coderscamps.Assignment14.domain.Channel;
import com.coderscamps.Assignment14.domain.Message;
import com.coderscamps.Assignment14.domain.User;
import com.coderscamps.Assignment14.dto.MessageDto;
import com.coderscamps.Assignment14.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private UserService userService;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public void createMessage(MessageDto messageDto) {
        Message newMessage = new Message();
        Channel channel = channelService.findById(messageDto.getChannelId());
        String messageContent = messageDto.getMessageContent();
        User user = userService.findById(messageDto.getUserId());
        newMessage.setUser(user);
        newMessage.setChannel(channel);
        newMessage.setMessageData(messageContent);
        messageRepository.save(newMessage);

    }

    public List<MessageDto> findByChannel(Long channelId) {
        Channel channel = channelService.findById(channelId);
        List<MessageDto> submittedMessages = new ArrayList<>();
        List<Message> messageList = messageRepository.findByChannel(channel);
//        List<Message> messageList = messageRepository.findAllByChannelId(channelId);

        for (Message message : messageList) {
            MessageDto messageDto = new MessageDto();
            messageDto.setSenderName(userService.findNameById(message.getUser().getUserId()));
            messageDto.setChannelId(message.getChannel().getChannelId());
            messageDto.setMessageContent(message.getMessageData());
            messageDto.setUserId(message.getUser().getUserId());
            submittedMessages.add(messageDto);
        }
        return submittedMessages;
    }

}
