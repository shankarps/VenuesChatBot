package com.shankar.venues.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shankar.venues.constants.ListConstants;
import com.shankar.venues.constants.MessageConstants;
import com.shankar.venues.model.Response;

@Component
public class EventTypeLogicImpl implements VenueLogic {

	@Autowired
	ListConstants listConstants;
	
	@Override
	public Response processLogic(String input) {
		
		String respStr = "";
		boolean processed = false;
		
		Response response = new Response();
		
		if(listConstants.getEvents().contains(input)){
			respStr = MessageConstants.WHEN_EVENT;
			processed = true;
		}
		response.setProcessed(processed);
		response.setResponse(respStr);
		
		return response;
		
	}

}
