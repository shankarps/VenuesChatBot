package com.shankar.venues.service;

import com.shankar.venues.model.Response;

public interface ChatProcessor {
	
	public Response processMessage(String userMessage, String myQuestion);

}
