package com.coderscamps.Assignment14.repository;

import com.coderscamps.Assignment14.domain.Channel;
import com.coderscamps.Assignment14.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {


    @Query(value = "SELECT * FROM Messages WHERE channel_id = ?", nativeQuery = true)
    List<Message> findAllByChannelId(Long channelId);


    public List<Message> findByChannel(Channel channelId);


}
