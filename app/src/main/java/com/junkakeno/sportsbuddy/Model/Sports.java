package com.junkakeno.sportsbuddy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.junkakeno.sportsbuddy.Controller.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class Sports {

	@SerializedName("sports")
	@Expose
	private ArrayList<SportsItem> sports;

	public void setSports(ArrayList<SportsItem> sports){
		this.sports = sports;
	}

	public ArrayList<SportsItem> getSports(){
		return sports;
	}

	//Helper

	public ArrayList<SportsItem> getSelectedSports(){
		ArrayList<SportsItem> sportsList = new ArrayList<>();
		for(SportsItem sportsItem: sports){
			String sport = sportsItem.getStrSport();
			if(sport.equals("Soccer") || sport.equals("Baseball") ||
					sport.equals("Basketball") || sport.equals("American Football") ||
					sport.equals("Ice Hockey") || sport.equals("Volleyball") ){
				sportsList.add(sportsItem);
			}
		}
		return sportsList;
	}

	public String getDefaultSport(){
		String deaultSport = "";
		for(SportsItem sport:sports){
			if(sport.getStrSport().equals("Soccer")){
				deaultSport = sport.getStrSport();
			}
		}
		return deaultSport;
	}
}