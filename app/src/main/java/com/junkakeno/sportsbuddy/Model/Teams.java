package com.junkakeno.sportsbuddy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Teams implements Parcelable {

	@SerializedName("teams")
	@Expose
	private List<TeamsItem> teams;

	protected Teams(Parcel in) {
		teams = in.createTypedArrayList(TeamsItem.CREATOR);
	}

	public static final Creator<Teams> CREATOR = new Creator<Teams>() {
		@Override
		public Teams createFromParcel(Parcel in) {
			return new Teams(in);
		}

		@Override
		public Teams[] newArray(int size) {
			return new Teams[size];
		}
	};

	public void setTeams(List<TeamsItem> teams){
		this.teams = teams;
	}

	public List<TeamsItem> getTeams(){
		return teams;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeTypedList(teams);
	}

	//Helper

	public void resetTeams(){
		if(teams!=null) {
			teams.clear();
		}
	}
}