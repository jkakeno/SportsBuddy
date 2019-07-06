package com.junkakeno.sportsbuddy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Events implements Parcelable{

	@SerializedName("events")
	@Expose
	private List<EventsItem> events;

	List<EventsItem> teamEvents;


	protected Events(Parcel in) {
		events = in.createTypedArrayList(EventsItem.CREATOR);
		teamEvents = in.createTypedArrayList(EventsItem.CREATOR);
	}

	public static final Creator<Events> CREATOR = new Creator<Events>() {
		@Override
		public Events createFromParcel(Parcel in) {
			return new Events(in);
		}

		@Override
		public Events[] newArray(int size) {
			return new Events[size];
		}
	};

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	public List<EventsItem> getTeamEvents() {
		return teamEvents;
	}

	public void setTeamEvents(TeamsItem team) {
		List<EventsItem> teamEvent = new ArrayList<>();
		for(EventsItem event:events){
			if(event.getStrHomeTeam().equals(team.getStrTeam()) ||
					event.getStrAwayTeam().equals(team.getStrTeam())){
				teamEvent.add(event);
			}
		}
		this.teamEvents =  teamEvent;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeTypedList(events);
		parcel.writeTypedList(teamEvents);
	}

	//Helper
	public void resetEvents(){
		if(events!=null) {
			events.clear();
		}
	}
}