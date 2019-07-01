package com.junkakeno.sportsbuddy.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaguesItem{

	@SerializedName("strLeagueAlternate")
	@Expose
	private String strLeagueAlternate;

	@SerializedName("strLeague")
	@Expose
	private String strLeague;

	@SerializedName("strSport")
	@Expose
	private String strSport;

	@SerializedName("idLeague")
	@Expose
	private String idLeague;

	public void setStrLeagueAlternate(String strLeagueAlternate){
		this.strLeagueAlternate = strLeagueAlternate;
	}

	public String getStrLeagueAlternate(){
		return strLeagueAlternate;
	}

	public void setStrLeague(String strLeague){
		this.strLeague = strLeague;
	}

	public String getStrLeague(){
		return strLeague;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setIdLeague(String idLeague){
		this.idLeague = idLeague;
	}

	public String getIdLeague(){
		return idLeague;
	}
}