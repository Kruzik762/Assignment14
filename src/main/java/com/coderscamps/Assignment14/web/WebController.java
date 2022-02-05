package com.coderscamps.Assignment14.web;

import com.coderscamps.Assignment14.domain.Channel;
import com.coderscamps.Assignment14.domain.User;
import com.coderscamps.Assignment14.service.ChannelService;
import com.coderscamps.Assignment14.service.MessageService;
import com.coderscamps.Assignment14.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class WebController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private ChannelService channelService;

    @GetMapping("/welcome")
    public String getWelcomePage(ModelMap modelMap){
        List<Channel> channels = channelService.findAll();
        modelMap.put("channels", channels);
        modelMap.put("channel", channels);
    return "welcome";
    }

    @PostMapping("/welcome/createChannel")
    public String createChannel(Channel channel){
        channelService.save(channel);
        return "redirect:/welcome";
    }

    @PostMapping("welcome/createUser")
    @ResponseBody
    public String createUser(@RequestBody String name) {
        userService.createUser(name);
        return "redirect:/welcome";
    }
}
