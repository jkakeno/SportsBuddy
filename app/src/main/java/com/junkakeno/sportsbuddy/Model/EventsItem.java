package com.junkakeno.sportsbuddy.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventsItem implements Parcelable {

	@SerializedName("intHomeShots")
	@Expose
	private String intHomeShots;

	@SerializedName("strSport")
	@Expose
	private String strSport;

	@SerializedName("strHomeLineupDefense")
	@Expose
	private String strHomeLineupDefense;

	@SerializedName("datetimeEventUTC")
	@Expose
	private Object datetimeEventUTC;

	@SerializedName("strAwayLineupSubstitutes")
	@Expose
	private String strAwayLineupSubstitutes;

	@SerializedName("strTweet1")
	@Expose
	private Object strTweet1;

	@SerializedName("strTweet2")
	@Expose
	private Object strTweet2;

	@SerializedName("strTweet3")
	@Expose
	private Object strTweet3;

	@SerializedName("idLeague")
	@Expose
	private String idLeague;

	@SerializedName("idSoccerXML")
	@Expose
	private String idSoccerXML;

	@SerializedName("strHomeLineupForward")
	@Expose
	private String strHomeLineupForward;

	@SerializedName("strTVStation")
	@Expose
	private Object strTVStation;

	@SerializedName("strHomeGoalDetails")
	@Expose
	private String strHomeGoalDetails;

	@SerializedName("strVideo")
	@Expose
	private Object strVideo;

	@SerializedName("strAwayLineupGoalkeeper")
	@Expose
	private String strAwayLineupGoalkeeper;

	@SerializedName("strAwayLineupMidfield")
	@Expose
	private String strAwayLineupMidfield;

	@SerializedName("idEvent")
	@Expose
	private String idEvent;

	@SerializedName("intRound")
	@Expose
	private String intRound;

	@SerializedName("strHomeYellowCards")
	@Expose
	private String strHomeYellowCards;

	@SerializedName("idHomeTeam")
	@Expose
	private String idHomeTeam;

	@SerializedName("intHomeScore")
	@Expose
	private String intHomeScore;

	@SerializedName("dateEvent")
	@Expose
	private String dateEvent;

	@SerializedName("strCountry")
	@Expose
	private Object strCountry;

	@SerializedName("strAwayTeam")
	@Expose
	private String strAwayTeam;

	@SerializedName("strHomeLineupMidfield")
	@Expose
	private String strHomeLineupMidfield;

	@SerializedName("strDate")
	@Expose
	private String strDate;

	@SerializedName("strHomeFormation")
	@Expose
	private String strHomeFormation;

	@SerializedName("strMap")
	@Expose
	private Object strMap;

	@SerializedName("idAwayTeam")
	@Expose
	private String idAwayTeam;

	@SerializedName("strAwayRedCards")
	@Expose
	private String strAwayRedCards;

	@SerializedName("strBanner")
	@Expose
	private Object strBanner;

	@SerializedName("strFanart")
	@Expose
	private Object strFanart;

	@SerializedName("strDescriptionEN")
	@Expose
	private Object strDescriptionEN;

	@SerializedName("strResult")
	@Expose
	private Object strResult;

	@SerializedName("strCircuit")
	@Expose
	private Object strCircuit;

	@SerializedName("intAwayShots")
	@Expose
	private String intAwayShots;

	@SerializedName("strFilename")
	@Expose
	private String strFilename;

	@SerializedName("strTime")
	@Expose
	private String strTime;

	@SerializedName("strAwayGoalDetails")
	@Expose
	private String strAwayGoalDetails;

	@SerializedName("strAwayLineupForward")
	@Expose
	private String strAwayLineupForward;

	@SerializedName("strLocked")
	@Expose
	private String strLocked;

	@SerializedName("strSeason")
	@Expose
	private String strSeason;

	@SerializedName("intSpectators")
	@Expose
	private String intSpectators;

	@SerializedName("strHomeRedCards")
	@Expose
	private String strHomeRedCards;

	@SerializedName("strHomeLineupGoalkeeper")
	@Expose
	private String strHomeLineupGoalkeeper;

	@SerializedName("strHomeLineupSubstitutes")
	@Expose
	private String strHomeLineupSubstitutes;

	@SerializedName("strAwayFormation")
	@Expose
	private String strAwayFormation;

	@SerializedName("strEvent")
	@Expose
	private String strEvent;

	@SerializedName("strAwayYellowCards")
	@Expose
	private String strAwayYellowCards;

	@SerializedName("strAwayLineupDefense")
	@Expose
	private String strAwayLineupDefense;

	@SerializedName("strHomeTeam")
	@Expose
	private String strHomeTeam;

	@SerializedName("strThumb")
	@Expose
	private Object strThumb;

	@SerializedName("strLeague")
	@Expose
	private String strLeague;

	@SerializedName("intAwayScore")
	@Expose
	private String intAwayScore;

	@SerializedName("strCity")
	@Expose
	private Object strCity;

	@SerializedName("strPoster")
	@Expose
	private Object strPoster;

	String homeBadge;

	String awayBadge;

	public String getHomeBadge() {
		return homeBadge;
	}

	public void setHomeBadge(String homeBadge) {
		this.homeBadge = homeBadge;
	}

	public String getAwayBadge() {
		return awayBadge;
	}

	public void setAwayBadge(String awayBadge) {
		this.awayBadge = awayBadge;
	}

	protected EventsItem(Parcel in) {
		intHomeShots = in.readString();
		strSport = in.readString();
		strHomeLineupDefense = in.readString();
		strAwayLineupSubstitutes = in.readString();
		idLeague = in.readString();
		idSoccerXML = in.readString();
		strHomeLineupForward = in.readString();
		strHomeGoalDetails = in.readString();
		strAwayLineupGoalkeeper = in.readString();
		strAwayLineupMidfield = in.readString();
		idEvent = in.readString();
		intRound = in.readString();
		strHomeYellowCards = in.readString();
		idHomeTeam = in.readString();
		intHomeScore = in.readString();
		dateEvent = in.readString();
		strAwayTeam = in.readString();
		strHomeLineupMidfield = in.readString();
		strDate = in.readString();
		strHomeFormation = in.readString();
		idAwayTeam = in.readString();
		strAwayRedCards = in.readString();
		intAwayShots = in.readString();
		strFilename = in.readString();
		strTime = in.readString();
		strAwayGoalDetails = in.readString();
		strAwayLineupForward = in.readString();
		strLocked = in.readString();
		strSeason = in.readString();
		intSpectators = in.readString();
		strHomeRedCards = in.readString();
		strHomeLineupGoalkeeper = in.readString();
		strHomeLineupSubstitutes = in.readString();
		strAwayFormation = in.readString();
		strEvent = in.readString();
		strAwayYellowCards = in.readString();
		strAwayLineupDefense = in.readString();
		strHomeTeam = in.readString();
		strLeague = in.readString();
		intAwayScore = in.readString();
		homeBadge = in.readString();
		awayBadge = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(intHomeShots);
		dest.writeString(strSport);
		dest.writeString(strHomeLineupDefense);
		dest.writeString(strAwayLineupSubstitutes);
		dest.writeString(idLeague);
		dest.writeString(idSoccerXML);
		dest.writeString(strHomeLineupForward);
		dest.writeString(strHomeGoalDetails);
		dest.writeString(strAwayLineupGoalkeeper);
		dest.writeString(strAwayLineupMidfield);
		dest.writeString(idEvent);
		dest.writeString(intRound);
		dest.writeString(strHomeYellowCards);
		dest.writeString(idHomeTeam);
		dest.writeString(intHomeScore);
		dest.writeString(dateEvent);
		dest.writeString(strAwayTeam);
		dest.writeString(strHomeLineupMidfield);
		dest.writeString(strDate);
		dest.writeString(strHomeFormation);
		dest.writeString(idAwayTeam);
		dest.writeString(strAwayRedCards);
		dest.writeString(intAwayShots);
		dest.writeString(strFilename);
		dest.writeString(strTime);
		dest.writeString(strAwayGoalDetails);
		dest.writeString(strAwayLineupForward);
		dest.writeString(strLocked);
		dest.writeString(strSeason);
		dest.writeString(intSpectators);
		dest.writeString(strHomeRedCards);
		dest.writeString(strHomeLineupGoalkeeper);
		dest.writeString(strHomeLineupSubstitutes);
		dest.writeString(strAwayFormation);
		dest.writeString(strEvent);
		dest.writeString(strAwayYellowCards);
		dest.writeString(strAwayLineupDefense);
		dest.writeString(strHomeTeam);
		dest.writeString(strLeague);
		dest.writeString(intAwayScore);
		dest.writeString(homeBadge);
		dest.writeString(awayBadge);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<EventsItem> CREATOR = new Creator<EventsItem>() {
		@Override
		public EventsItem createFromParcel(Parcel in) {
			return new EventsItem(in);
		}

		@Override
		public EventsItem[] newArray(int size) {
			return new EventsItem[size];
		}
	};

	public void setIntHomeShots(String intHomeShots){
		this.intHomeShots = intHomeShots;
	}

	public String getIntHomeShots(){
		return intHomeShots;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setStrHomeLineupDefense(String strHomeLineupDefense){
		this.strHomeLineupDefense = strHomeLineupDefense;
	}

	public String getStrHomeLineupDefense(){
		return strHomeLineupDefense;
	}

	public void setDatetimeEventUTC(Object datetimeEventUTC){
		this.datetimeEventUTC = datetimeEventUTC;
	}

	public Object getDatetimeEventUTC(){
		return datetimeEventUTC;
	}

	public void setStrAwayLineupSubstitutes(String strAwayLineupSubstitutes){
		this.strAwayLineupSubstitutes = strAwayLineupSubstitutes;
	}

	public String getStrAwayLineupSubstitutes(){
		return strAwayLineupSubstitutes;
	}

	public void setStrTweet1(Object strTweet1){
		this.strTweet1 = strTweet1;
	}

	public Object getStrTweet1(){
		return strTweet1;
	}

	public void setStrTweet2(Object strTweet2){
		this.strTweet2 = strTweet2;
	}

	public Object getStrTweet2(){
		return strTweet2;
	}

	public void setStrTweet3(Object strTweet3){
		this.strTweet3 = strTweet3;
	}

	public Object getStrTweet3(){
		return strTweet3;
	}

	public void setIdLeague(String idLeague){
		this.idLeague = idLeague;
	}

	public String getIdLeague(){
		return idLeague;
	}

	public void setIdSoccerXML(String idSoccerXML){
		this.idSoccerXML = idSoccerXML;
	}

	public String getIdSoccerXML(){
		return idSoccerXML;
	}

	public void setStrHomeLineupForward(String strHomeLineupForward){
		this.strHomeLineupForward = strHomeLineupForward;
	}

	public String getStrHomeLineupForward(){
		return strHomeLineupForward;
	}

	public void setStrTVStation(Object strTVStation){
		this.strTVStation = strTVStation;
	}

	public Object getStrTVStation(){
		return strTVStation;
	}

	public void setStrHomeGoalDetails(String strHomeGoalDetails){
		this.strHomeGoalDetails = strHomeGoalDetails;
	}

	public String getStrHomeGoalDetails(){
		return strHomeGoalDetails;
	}

	public void setStrVideo(Object strVideo){
		this.strVideo = strVideo;
	}

	public Object getStrVideo(){
		return strVideo;
	}

	public void setStrAwayLineupGoalkeeper(String strAwayLineupGoalkeeper){
		this.strAwayLineupGoalkeeper = strAwayLineupGoalkeeper;
	}

	public String getStrAwayLineupGoalkeeper(){
		return strAwayLineupGoalkeeper;
	}

	public void setStrAwayLineupMidfield(String strAwayLineupMidfield){
		this.strAwayLineupMidfield = strAwayLineupMidfield;
	}

	public String getStrAwayLineupMidfield(){
		return strAwayLineupMidfield;
	}

	public void setIdEvent(String idEvent){
		this.idEvent = idEvent;
	}

	public String getIdEvent(){
		return idEvent;
	}

	public void setIntRound(String intRound){
		this.intRound = intRound;
	}

	public String getIntRound(){
		return intRound;
	}

	public void setStrHomeYellowCards(String strHomeYellowCards){
		this.strHomeYellowCards = strHomeYellowCards;
	}

	public String getStrHomeYellowCards(){
		return strHomeYellowCards;
	}

	public void setIdHomeTeam(String idHomeTeam){
		this.idHomeTeam = idHomeTeam;
	}

	public String getIdHomeTeam(){
		return idHomeTeam;
	}

	public void setIntHomeScore(String intHomeScore){
		this.intHomeScore = intHomeScore;
	}

	public String getIntHomeScore(){
		return intHomeScore;
	}

	public void setDateEvent(String dateEvent){
		this.dateEvent = dateEvent;
	}

	public String getDateEvent(){
		return dateEvent;
	}

	public void setStrCountry(Object strCountry){
		this.strCountry = strCountry;
	}

	public Object getStrCountry(){
		return strCountry;
	}

	public void setStrAwayTeam(String strAwayTeam){
		this.strAwayTeam = strAwayTeam;
	}

	public String getStrAwayTeam(){
		return strAwayTeam;
	}

	public void setStrHomeLineupMidfield(String strHomeLineupMidfield){
		this.strHomeLineupMidfield = strHomeLineupMidfield;
	}

	public String getStrHomeLineupMidfield(){
		return strHomeLineupMidfield;
	}

	public void setStrDate(String strDate){
		this.strDate = strDate;
	}

	public String getStrDate(){
		return strDate;
	}

	public void setStrHomeFormation(String strHomeFormation){
		this.strHomeFormation = strHomeFormation;
	}

	public String getStrHomeFormation(){
		return strHomeFormation;
	}

	public void setStrMap(Object strMap){
		this.strMap = strMap;
	}

	public Object getStrMap(){
		return strMap;
	}

	public void setIdAwayTeam(String idAwayTeam){
		this.idAwayTeam = idAwayTeam;
	}

	public String getIdAwayTeam(){
		return idAwayTeam;
	}

	public void setStrAwayRedCards(String strAwayRedCards){
		this.strAwayRedCards = strAwayRedCards;
	}

	public String getStrAwayRedCards(){
		return strAwayRedCards;
	}

	public void setStrBanner(Object strBanner){
		this.strBanner = strBanner;
	}

	public Object getStrBanner(){
		return strBanner;
	}

	public void setStrFanart(Object strFanart){
		this.strFanart = strFanart;
	}

	public Object getStrFanart(){
		return strFanart;
	}

	public void setStrDescriptionEN(Object strDescriptionEN){
		this.strDescriptionEN = strDescriptionEN;
	}

	public Object getStrDescriptionEN(){
		return strDescriptionEN;
	}

	public void setStrResult(Object strResult){
		this.strResult = strResult;
	}

	public Object getStrResult(){
		return strResult;
	}

	public void setStrCircuit(Object strCircuit){
		this.strCircuit = strCircuit;
	}

	public Object getStrCircuit(){
		return strCircuit;
	}

	public void setIntAwayShots(String intAwayShots){
		this.intAwayShots = intAwayShots;
	}

	public String getIntAwayShots(){
		return intAwayShots;
	}

	public void setStrFilename(String strFilename){
		this.strFilename = strFilename;
	}

	public String getStrFilename(){
		return strFilename;
	}

	public void setStrTime(String strTime){
		this.strTime = strTime;
	}

	public String getStrTime(){
		return strTime;
	}

	public void setStrAwayGoalDetails(String strAwayGoalDetails){
		this.strAwayGoalDetails = strAwayGoalDetails;
	}

	public String getStrAwayGoalDetails(){
		return strAwayGoalDetails;
	}

	public void setStrAwayLineupForward(String strAwayLineupForward){
		this.strAwayLineupForward = strAwayLineupForward;
	}

	public String getStrAwayLineupForward(){
		return strAwayLineupForward;
	}

	public void setStrLocked(String strLocked){
		this.strLocked = strLocked;
	}

	public String getStrLocked(){
		return strLocked;
	}

	public void setStrSeason(String strSeason){
		this.strSeason = strSeason;
	}

	public String getStrSeason(){
		return strSeason;
	}

	public void setIntSpectators(String intSpectators){
		this.intSpectators = intSpectators;
	}

	public String getIntSpectators(){
		return intSpectators;
	}

	public void setStrHomeRedCards(String strHomeRedCards){
		this.strHomeRedCards = strHomeRedCards;
	}

	public String getStrHomeRedCards(){
		return strHomeRedCards;
	}

	public void setStrHomeLineupGoalkeeper(String strHomeLineupGoalkeeper){
		this.strHomeLineupGoalkeeper = strHomeLineupGoalkeeper;
	}

	public String getStrHomeLineupGoalkeeper(){
		return strHomeLineupGoalkeeper;
	}

	public void setStrHomeLineupSubstitutes(String strHomeLineupSubstitutes){
		this.strHomeLineupSubstitutes = strHomeLineupSubstitutes;
	}

	public String getStrHomeLineupSubstitutes(){
		return strHomeLineupSubstitutes;
	}

	public void setStrAwayFormation(String strAwayFormation){
		this.strAwayFormation = strAwayFormation;
	}

	public String getStrAwayFormation(){
		return strAwayFormation;
	}

	public void setStrEvent(String strEvent){
		this.strEvent = strEvent;
	}

	public String getStrEvent(){
		return strEvent;
	}

	public void setStrAwayYellowCards(String strAwayYellowCards){
		this.strAwayYellowCards = strAwayYellowCards;
	}

	public String getStrAwayYellowCards(){
		return strAwayYellowCards;
	}

	public void setStrAwayLineupDefense(String strAwayLineupDefense){
		this.strAwayLineupDefense = strAwayLineupDefense;
	}

	public String getStrAwayLineupDefense(){
		return strAwayLineupDefense;
	}

	public void setStrHomeTeam(String strHomeTeam){
		this.strHomeTeam = strHomeTeam;
	}

	public String getStrHomeTeam(){
		return strHomeTeam;
	}

	public void setStrThumb(Object strThumb){
		this.strThumb = strThumb;
	}

	public Object getStrThumb(){
		return strThumb;
	}

	public void setStrLeague(String strLeague){
		this.strLeague = strLeague;
	}

	public String getStrLeague(){
		return strLeague;
	}

	public void setIntAwayScore(String intAwayScore){
		this.intAwayScore = intAwayScore;
	}

	public String getIntAwayScore(){
		return intAwayScore;
	}

	public void setStrCity(Object strCity){
		this.strCity = strCity;
	}

	public Object getStrCity(){
		return strCity;
	}

	public void setStrPoster(Object strPoster){
		this.strPoster = strPoster;
	}

	public Object getStrPoster(){
		return strPoster;
	}
}