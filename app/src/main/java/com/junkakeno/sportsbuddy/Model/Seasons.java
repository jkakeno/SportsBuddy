package com.junkakeno.sportsbuddy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seasons{

	@SerializedName("seasons")
	@Expose
	private List<SeasonsItem> seasons;

	public void setSeasons(List<SeasonsItem> seasons){
		this.seasons = seasons;
	}

	public List<SeasonsItem> getSeasons(){
		return seasons;
	}
}