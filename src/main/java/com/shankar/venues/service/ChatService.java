package com.shankar.venues.service;

import java.util.List;

import com.shankar.venues.model.Chat;

public interface ChatService {
	
	public List<Chat> chat(Chat chatMessage, List<Chat> messageList);

	public List<Chat> startChat();

}
