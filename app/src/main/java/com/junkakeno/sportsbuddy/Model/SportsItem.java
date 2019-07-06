package com.junkakeno.sportsbuddy.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SportsItem implements Parcelable {

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

	protected SportsItem(Parcel in) {
		idSport = in.readString();
		strSport = in.readString();
		strSportThumb = in.readString();
		strSportDescription = in.readString();
	}

	public static final Creator<SportsItem> CREATOR = new Creator<SportsItem>() {
		@Override
		public SportsItem createFromParcel(Parcel in) {
			return new SportsItem(in);
		}

		@Override
		public SportsItem[] newArray(int size) {
			return new SportsItem[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(idSport);
		parcel.writeString(strSport);
		parcel.writeString(strSportThumb);
		parcel.writeString(strSportDescription);
	}
}