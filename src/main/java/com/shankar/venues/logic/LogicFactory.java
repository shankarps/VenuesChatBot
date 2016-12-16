package com.shankar.venues.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shankar.venues.constants.MessageConstants;

@Component
public class LogicFactory {
	
	@Autowired
	EventTypeLogicImpl eventTypeLogicImpl;
	
	@Autowired
	DateLogicImpl dateLogicImpl;
	
	@Autowired
	AdiosLogic adiosLogic;

	public VenueLogic getLogic(String myQuestion){
		VenueLogic logic = null;
		//get the logic processor based on the last question (that was answered)
		if(myQuestion.equals(MessageConstants.WHAT_EVENT)){
			logic = eventTypeLogicImpl;
		}else if(myQuestion.equals(MessageConstants.WHEN_EVENT)){
			logic = dateLogicImpl;
		}else if(myQuestion.equals(MessageConstants.THANK_YOU)){
			logic = adiosLogic;
		}else{
			
		}
		
		return logic;
	}
}
