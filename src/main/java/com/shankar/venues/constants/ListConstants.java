package com.shankar.venues.constants;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListConstants {
	
	private ArrayList<String> events = new ArrayList<String>();
	
	public ListConstants(){
		events.add("Wedding");
		events.add("Birthday");
		events.add("Corporate");
		events.add("Other");
	}

	public ArrayList<String> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<String> events) {
		this.events = events;
	}
	

}
