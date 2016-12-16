package com.shankar.venues.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.venues.model.Chat;
import com.shankar.venues.service.ChatService;

@RestController
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
    @RequestMapping(value = {"/chat"}, 
    		method = RequestMethod.POST,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    	    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Chat> postChat(@RequestBody Chat chat, HttpSession httpSession){
    	List<Chat> messageList = (List<Chat>) httpSession.getAttribute("CHAT_LIST");
        List<Chat> chatList = chatService.chat(chat, messageList);
        httpSession.setAttribute("CHAT_LIST", chatList);
        return chatList;
        
    }
    
    @RequestMapping(value = {"/chat"}, 
    		method = RequestMethod.GET,
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    	    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Chat> startChat(HttpSession httpSession){
    	List<Chat> messageList = (List<Chat>) httpSession.getAttribute("CHAT_LIST");
        List<Chat> chatList = chatService.startChat();
        httpSession.setAttribute("CHAT_LIST", chatList);
        return chatList;
        
    }
}