package com.coderscamps.Assignment14.service;

import com.coderscamps.Assignment14.domain.Channel;
import com.coderscamps.Assignment14.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public Channel save(Channel channel) {
        return channelRepository.save(channel);
    }

    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

}
