package com.shankar.venues.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shankar.venues.logic.LogicFactory;
import com.shankar.venues.logic.VenueLogic;
import com.shankar.venues.model.Response;

@Component
public class ChatProcessorImpl implements ChatProcessor {

	@Autowired
	LogicFactory logicFactory;
	
	@Override
	public Response processMessage(String userMessage, String myQuestion) {
		
		VenueLogic logic = logicFactory.getLogic(myQuestion);
		
		return logic.processLogic(userMessage);
		
	}

}
