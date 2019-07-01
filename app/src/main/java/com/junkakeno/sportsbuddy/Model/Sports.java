package com.junkakeno.sportsbuddy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sports {

	@SerializedName("sports")
	@Expose
	private List<SportsItem> sports;

	public void setSports(List<SportsItem> sports){
		this.sports = sports;
	}

	public List<SportsItem> getSports(){
		return sports;
	}
}