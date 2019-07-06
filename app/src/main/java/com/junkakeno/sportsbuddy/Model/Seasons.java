package com.junkakeno.sportsbuddy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seasons implements Parcelable {

	@SerializedName("seasons")
	@Expose
	private List<SeasonsItem> seasons;

	protected Seasons(Parcel in) {
	}

	public static final Creator<Seasons> CREATOR = new Creator<Seasons>() {
		@Override
		public Seasons createFromParcel(Parcel in) {
			return new Seasons(in);
		}

		@Override
		public Seasons[] newArray(int size) {
			return new Seasons[size];
		}
	};

	public void setSeasons(List<SeasonsItem> seasons){
		this.seasons = seasons;
	}

	public List<SeasonsItem> getSeasons(){
		return seasons;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
	}
}