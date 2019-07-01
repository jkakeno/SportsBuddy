package com.junkakeno.sportsbuddy.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SeasonsItem{

	@SerializedName("strSeason")
	@Expose
	private String strSeason;

	public void setStrSeason(String strSeason){
		this.strSeason = strSeason;
	}

	public String getStrSeason(){
		return strSeason;
	}
}