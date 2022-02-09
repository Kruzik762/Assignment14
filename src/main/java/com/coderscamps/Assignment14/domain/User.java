package com.coderscamps.Assignment14.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_channel",
//    joinColumns = {@JoinColumn(name = "user_id")},
//    inverseJoinColumns = {@JoinColumn(name = "channel_id")})
//    private List<Channel> channels = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "user_message",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "message_id")})
    private List<Message> messages = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long id) {
        this.userId = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }

    //    public List<Channel> getChannels() {
//        return channels;
//    }
//
//    public void setChannels(List<Channel> channels) {
//        this.channels = channels;
//    }
}
