package com.junkakeno.sportsbuddy.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SportsItem {

	@SerializedName("idSport")
	@Expose
	private String idSport;

	@SerializedName("strSport")
	@Expose
	private String strSport;

	@SerializedName("strSportThumb")
	@Expose
	private String strSportThumb;

	@SerializedName("strSportDescription")
	@Expose
	private String strSportDescription;

	public void setIdSport(String idSport){
		this.idSport = idSport;
	}

	public String getIdSport(){
		return idSport;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setStrSportThumb(String strSportThumb){
		this.strSportThumb = strSportThumb;
	}

	public String getStrSportThumb(){
		return strSportThumb;
	}

	public void setStrSportDescription(String strSportDescription){
		this.strSportDescription = strSportDescription;
	}

	public String getStrSportDescription(){
		return strSportDescription;
	}
}