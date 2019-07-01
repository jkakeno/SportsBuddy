package com.junkakeno.sportsbuddy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Leagues{

	@SerializedName("leagues")
	@Expose
	private List<LeaguesItem> leagues;

	public void setLeagues(List<LeaguesItem> leagues){
		this.leagues = leagues;
	}

	public List<LeaguesItem> getLeagues(){
		return leagues;
	}
}