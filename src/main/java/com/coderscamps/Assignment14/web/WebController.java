package com.coderscamps.Assignment14.web;

import com.coderscamps.Assignment14.domain.Channel;
import com.coderscamps.Assignment14.domain.Message;
import com.coderscamps.Assignment14.domain.User;
import com.coderscamps.Assignment14.dto.MessageDto;
import com.coderscamps.Assignment14.service.ChannelService;
import com.coderscamps.Assignment14.service.MessageService;
import com.coderscamps.Assignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class WebController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private ChannelService channelService;

    @GetMapping("/")
    public String goHome() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String getWelcomePage(){
    return "welcome";
    }

    @ResponseBody
    @PostMapping("welcome/createUser")
    public User createUser(@RequestBody String displayName) {
        return userService.createUser(displayName);
    }

    @GetMapping("/channels/{channelId}")
    public String getChannelPage(ModelMap modelMap, @PathVariable Long channelId) {
        Channel channel = channelService.findById(channelId);
        modelMap.put("channel", channel );
        return "chatRoom";
    }

    @ResponseBody
    @PostMapping("/channels/{channelId}/createMessage")
    public void postMessage(@RequestBody MessageDto message) {
        messageService.createMessage(message);
    }

    @ResponseBody
    @PostMapping("/channels/{channelId}/getMessages")
    public List<MessageDto> messages (@PathVariable Long channelId) {
        return messageService.findByChannel(channelId);
    }

    @GetMapping("/channels")
    public String getChannels(ModelMap modelMap) {
        List<Channel> channels = channelService.findAll();
        modelMap.put("channels", channels);
        return "channels";
    }

    @GetMapping("/createChannel")
    public String getChannelCreationPage(ModelMap modelMap) {
        Channel channel = new Channel();
        modelMap.put("channel", channel);
        return "channelBuilder";
    }
    @PostMapping("/createChannel")
    public String createChannel(Channel channel){
        channelService.save(channel);
        System.out.println("Channel name: " + channel.getChannelName() + "--ID: " + channel.getChannelId());
        return "redirect:/channels";
    }
}
