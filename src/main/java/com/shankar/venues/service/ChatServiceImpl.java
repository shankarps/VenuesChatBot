package com.shankar.venues.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.venues.constants.MessageConstants;
import com.shankar.venues.model.Chat;
import com.shankar.venues.model.Response;
import com.shankar.venues.model.Source;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatProcessor chatProcessor;

	@Override
	public List<Chat> chat(Chat chatMessage, List<Chat> messageList) {
		
		List<Chat> updatedList = new ArrayList();
		
		updatedList = messageList;
		
		if(updatedList == null || updatedList.size() ==0){
			updatedList = new ArrayList<Chat>();
			updatedList.add(new Chat(MessageConstants.HELLO_1, Source.ADMIN));
			updatedList.add(new Chat(MessageConstants.HELLO_2, Source.ADMIN));
			updatedList.add(new Chat(MessageConstants.WHAT_EVENT, Source.ADMIN));
		}
		else{
			//Send the current answer and the last question
			String myQyestion = messageList.get(messageList.size() -1).getMessage();
			String guestAnswer = chatMessage.getMessage();
			Response nextResponse = chatProcessor.processMessage(guestAnswer, myQyestion);

			chatMessage.setSource(Source.GUEST);
			updatedList.add(chatMessage);
			
			//check if processed correctly
			if(nextResponse.getProcessed()){
				Chat nextQuestion = new Chat();
				nextQuestion.setMessage(nextResponse.getResponse());
				nextQuestion.setSource(Source.ADMIN);
				updatedList.add(nextQuestion);
			}else{
				//Not processed. Ask again :(
				Chat apology = new Chat();
				//Add apology first :(
				apology.setMessage(MessageConstants.CANNOT_UNDERSTAND);
				apology.setSource(Source.ADMIN);
				updatedList.add(apology);
				//Ask again
				Chat nextQuestion = new Chat();
				nextQuestion.setMessage(myQyestion);
				nextQuestion.setSource(Source.ADMIN);
				updatedList.add(nextQuestion);
			}
		}
		return updatedList;
	}

	@Override
	public List<Chat> startChat() {
		List<Chat> updatedList = new ArrayList<Chat>();
		updatedList.add(new Chat(MessageConstants.HELLO_1, Source.ADMIN));
		updatedList.add(new Chat(MessageConstants.HELLO_2, Source.ADMIN));
		updatedList.add(new Chat(MessageConstants.WHAT_EVENT, Source.ADMIN));
		
		return updatedList;	
	}
}
