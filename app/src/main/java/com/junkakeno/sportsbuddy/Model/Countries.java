package com.junkakeno.sportsbuddy.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Countries implements Parcelable {

	@SerializedName("countrys")
	@Expose
	private List<CountrysItem> countrys = new ArrayList<>();


	protected Countries(Parcel in) {
	}

	public static final Creator<Countries> CREATOR = new Creator<Countries>() {
		@Override
		public Countries createFromParcel(Parcel in) {
			return new Countries(in);
		}

		@Override
		public Countries[] newArray(int size) {
			return new Countries[size];
		}
	};

	public void setCountrys(List<CountrysItem> countrys){
		this.countrys = countrys;
	}

	public List<CountrysItem> getCountrys(){
		return countrys;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
	}

	public void addLeague(CountrysItem country){
		this.countrys.add(country);
	}
}