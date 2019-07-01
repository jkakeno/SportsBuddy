package com.junkakeno.sportsbuddy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events{

	@SerializedName("events")
	@Expose
	private List<EventsItem> events;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}
}