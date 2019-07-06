package com.junkakeno.sportsbuddy.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamsItem implements Parcelable{

	@SerializedName("intStadiumCapacity")
	@Expose
	private String intStadiumCapacity;

	@SerializedName("strTeamShort")
	@Expose
	private String strTeamShort;

	@SerializedName("strSport")
	@Expose
	private String strSport;

	@SerializedName("strDescriptionCN")
	@Expose
	private Object strDescriptionCN;

	@SerializedName("strTeamJersey")
	@Expose
	private String strTeamJersey;

	@SerializedName("strTeamFanart2")
	@Expose
	private String strTeamFanart2;

	@SerializedName("strTeamFanart3")
	@Expose
	private String strTeamFanart3;

	@SerializedName("strTeamFanart4")
	@Expose
	private String strTeamFanart4;

	@SerializedName("strStadiumDescription")
	@Expose
	private String strStadiumDescription;

	@SerializedName("strTeamFanart1")
	@Expose
	private String strTeamFanart1;

	@SerializedName("intLoved")
	@Expose
	private String intLoved;

	@SerializedName("idLeague")
	@Expose
	private String idLeague;

	@SerializedName("idSoccerXML")
	@Expose
	private String idSoccerXML;

	@SerializedName("strTeamLogo")
	@Expose
	private String strTeamLogo;

	@SerializedName("strDescriptionSE")
	@Expose
	private Object strDescriptionSE;

	@SerializedName("strDescriptionJP")
	@Expose
	private Object strDescriptionJP;

	@SerializedName("strDescriptionFR")
	@Expose
	private Object strDescriptionFR;

	@SerializedName("strStadiumLocation")
	@Expose
	private String strStadiumLocation;

	@SerializedName("strDescriptionNL")
	@Expose
	private Object strDescriptionNL;

	@SerializedName("strCountry")
	@Expose
	private String strCountry;

	@SerializedName("strRSS")
	@Expose
	private String strRSS;

	@SerializedName("strDescriptionRU")
	@Expose
	private Object strDescriptionRU;

	@SerializedName("strTeamBanner")
	@Expose
	private String strTeamBanner;

	@SerializedName("strDescriptionNO")
	@Expose
	private Object strDescriptionNO;

	@SerializedName("strStadiumThumb")
	@Expose
	private String strStadiumThumb;

	@SerializedName("strDescriptionES")
	@Expose
	private Object strDescriptionES;

	@SerializedName("intFormedYear")
	@Expose
	private String intFormedYear;

	@SerializedName("strInstagram")
	@Expose
	private String strInstagram;

	@SerializedName("strDescriptionIT")
	@Expose
	private String strDescriptionIT;

	@SerializedName("idTeam")
	@Expose
	private String idTeam;

	@SerializedName("strDescriptionEN")
	@Expose
	private String strDescriptionEN;

	@SerializedName("strWebsite")
	@Expose
	private String strWebsite;

	@SerializedName("strYoutube")
	@Expose
	private String strYoutube;

	@SerializedName("strDescriptionIL")
	@Expose
	private Object strDescriptionIL;

	@SerializedName("strLocked")
	@Expose
	private String strLocked;

	@SerializedName("strAlternate")
	@Expose
	private String strAlternate;

	@SerializedName("strTeam")
	@Expose
	private String strTeam;

	@SerializedName("strTwitter")
	@Expose
	private String strTwitter;

	@SerializedName("strDescriptionHU")
	@Expose
	private Object strDescriptionHU;

	@SerializedName("strGender")
	@Expose
	private String strGender;

	@SerializedName("strDivision")
	@Expose
	private Object strDivision;

	@SerializedName("strStadium")
	@Expose
	private String strStadium;

	@SerializedName("strFacebook")
	@Expose
	private String strFacebook;

	@SerializedName("strTeamBadge")
	@Expose
	private String strTeamBadge;

	@SerializedName("strDescriptionPT")
	@Expose
	private Object strDescriptionPT;

	@SerializedName("strDescriptionDE")
	@Expose
	private String strDescriptionDE;

	@SerializedName("strLeague")
	@Expose
	private String strLeague;

	@SerializedName("strManager")
	@Expose
	private String strManager;

	@SerializedName("strKeywords")
	@Expose
	private String strKeywords;

	@SerializedName("strDescriptionPL")
	@Expose
	private Object strDescriptionPL;

	boolean isFavorite;

	ArrayList<EventsItem> teamEvents;


	protected TeamsItem(Parcel in) {
		intStadiumCapacity = in.readString();
		strTeamShort = in.readString();
		strSport = in.readString();
		strTeamJersey = in.readString();
		strTeamFanart2 = in.readString();
		strTeamFanart3 = in.readString();
		strTeamFanart4 = in.readString();
		strStadiumDescription = in.readString();
		strTeamFanart1 = in.readString();
		intLoved = in.readString();
		idLeague = in.readString();
		idSoccerXML = in.readString();
		strTeamLogo = in.readString();
		strStadiumLocation = in.readString();
		strCountry = in.readString();
		strRSS = in.readString();
		strTeamBanner = in.readString();
		strStadiumThumb = in.readString();
		intFormedYear = in.readString();
		strInstagram = in.readString();
		strDescriptionIT = in.readString();
		idTeam = in.readString();
		strDescriptionEN = in.readString();
		strWebsite = in.readString();
		strYoutube = in.readString();
		strLocked = in.readString();
		strAlternate = in.readString();
		strTeam = in.readString();
		strTwitter = in.readString();
		strGender = in.readString();
		strStadium = in.readString();
		strFacebook = in.readString();
		strTeamBadge = in.readString();
		strDescriptionDE = in.readString();
		strLeague = in.readString();
		strManager = in.readString();
		strKeywords = in.readString();
		isFavorite = in.readByte() != 0;
		teamEvents = in.createTypedArrayList(EventsItem.CREATOR);
	}

	public static final Creator<TeamsItem> CREATOR = new Creator<TeamsItem>() {
		@Override
		public TeamsItem createFromParcel(Parcel in) {
			return new TeamsItem(in);
		}

		@Override
		public TeamsItem[] newArray(int size) {
			return new TeamsItem[size];
		}
	};

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean favorite) {
		isFavorite = favorite;
	}


	public ArrayList<EventsItem> getTeamEvents() {
		return teamEvents;
	}

	public void resetTeamEvent(){
		teamEvents = new ArrayList<>();
	}

	public void addTeamEvent(Events events){
		for(EventsItem event:events.getEvents()) {
			teamEvents.add(event);
		}
	}

	public void setTeamEvents(ArrayList<EventsItem> teamEvents) {
		this.teamEvents = teamEvents;
	}

	public void setIntStadiumCapacity(String intStadiumCapacity){
		this.intStadiumCapacity = intStadiumCapacity;
	}

	public String getIntStadiumCapacity(){
		return intStadiumCapacity;
	}

	public void setStrTeamShort(String strTeamShort){
		this.strTeamShort = strTeamShort;
	}

	public String getStrTeamShort(){
		return strTeamShort;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setStrDescriptionCN(Object strDescriptionCN){
		this.strDescriptionCN = strDescriptionCN;
	}

	public Object getStrDescriptionCN(){
		return strDescriptionCN;
	}

	public void setStrTeamJersey(String strTeamJersey){
		this.strTeamJersey = strTeamJersey;
	}

	public String getStrTeamJersey(){
		return strTeamJersey;
	}

	public void setStrTeamFanart2(String strTeamFanart2){
		this.strTeamFanart2 = strTeamFanart2;
	}

	public String getStrTeamFanart2(){
		return strTeamFanart2;
	}

	public void setStrTeamFanart3(String strTeamFanart3){
		this.strTeamFanart3 = strTeamFanart3;
	}

	public String getStrTeamFanart3(){
		return strTeamFanart3;
	}

	public void setStrTeamFanart4(String strTeamFanart4){
		this.strTeamFanart4 = strTeamFanart4;
	}

	public String getStrTeamFanart4(){
		return strTeamFanart4;
	}

	public void setStrStadiumDescription(String strStadiumDescription){
		this.strStadiumDescription = strStadiumDescription;
	}

	public String getStrStadiumDescription(){
		return strStadiumDescription;
	}

	public void setStrTeamFanart1(String strTeamFanart1){
		this.strTeamFanart1 = strTeamFanart1;
	}

	public String getStrTeamFanart1(){
		return strTeamFanart1;
	}

	public void setIntLoved(String intLoved){
		this.intLoved = intLoved;
	}

	public String getIntLoved(){
		return intLoved;
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

	public void setStrTeamLogo(String strTeamLogo){
		this.strTeamLogo = strTeamLogo;
	}

	public String getStrTeamLogo(){
		return strTeamLogo;
	}

	public void setStrDescriptionSE(Object strDescriptionSE){
		this.strDescriptionSE = strDescriptionSE;
	}

	public Object getStrDescriptionSE(){
		return strDescriptionSE;
	}

	public void setStrDescriptionJP(Object strDescriptionJP){
		this.strDescriptionJP = strDescriptionJP;
	}

	public Object getStrDescriptionJP(){
		return strDescriptionJP;
	}

	public void setStrDescriptionFR(Object strDescriptionFR){
		this.strDescriptionFR = strDescriptionFR;
	}

	public Object getStrDescriptionFR(){
		return strDescriptionFR;
	}

	public void setStrStadiumLocation(String strStadiumLocation){
		this.strStadiumLocation = strStadiumLocation;
	}

	public String getStrStadiumLocation(){
		return strStadiumLocation;
	}

	public void setStrDescriptionNL(Object strDescriptionNL){
		this.strDescriptionNL = strDescriptionNL;
	}

	public Object getStrDescriptionNL(){
		return strDescriptionNL;
	}

	public void setStrCountry(String strCountry){
		this.strCountry = strCountry;
	}

	public String getStrCountry(){
		return strCountry;
	}

	public void setStrRSS(String strRSS){
		this.strRSS = strRSS;
	}

	public String getStrRSS(){
		return strRSS;
	}

	public void setStrDescriptionRU(Object strDescriptionRU){
		this.strDescriptionRU = strDescriptionRU;
	}

	public Object getStrDescriptionRU(){
		return strDescriptionRU;
	}

	public void setStrTeamBanner(String strTeamBanner){
		this.strTeamBanner = strTeamBanner;
	}

	public String getStrTeamBanner(){
		return strTeamBanner;
	}

	public void setStrDescriptionNO(Object strDescriptionNO){
		this.strDescriptionNO = strDescriptionNO;
	}

	public Object getStrDescriptionNO(){
		return strDescriptionNO;
	}

	public void setStrStadiumThumb(String strStadiumThumb){
		this.strStadiumThumb = strStadiumThumb;
	}

	public String getStrStadiumThumb(){
		return strStadiumThumb;
	}

	public void setStrDescriptionES(Object strDescriptionES){
		this.strDescriptionES = strDescriptionES;
	}

	public Object getStrDescriptionES(){
		return strDescriptionES;
	}

	public void setIntFormedYear(String intFormedYear){
		this.intFormedYear = intFormedYear;
	}

	public String getIntFormedYear(){
		return intFormedYear;
	}

	public void setStrInstagram(String strInstagram){
		this.strInstagram = strInstagram;
	}

	public String getStrInstagram(){
		return strInstagram;
	}

	public void setStrDescriptionIT(String strDescriptionIT){
		this.strDescriptionIT = strDescriptionIT;
	}

	public String getStrDescriptionIT(){
		return strDescriptionIT;
	}

	public void setIdTeam(String idTeam){
		this.idTeam = idTeam;
	}

	public String getIdTeam(){
		return idTeam;
	}

	public void setStrDescriptionEN(String strDescriptionEN){
		this.strDescriptionEN = strDescriptionEN;
	}

	public String getStrDescriptionEN(){
		return strDescriptionEN;
	}

	public void setStrWebsite(String strWebsite){
		this.strWebsite = strWebsite;
	}

	public String getStrWebsite(){
		return strWebsite;
	}

	public void setStrYoutube(String strYoutube){
		this.strYoutube = strYoutube;
	}

	public String getStrYoutube(){
		return strYoutube;
	}

	public void setStrDescriptionIL(Object strDescriptionIL){
		this.strDescriptionIL = strDescriptionIL;
	}

	public Object getStrDescriptionIL(){
		return strDescriptionIL;
	}

	public void setStrLocked(String strLocked){
		this.strLocked = strLocked;
	}

	public String getStrLocked(){
		return strLocked;
	}

	public void setStrAlternate(String strAlternate){
		this.strAlternate = strAlternate;
	}

	public String getStrAlternate(){
		return strAlternate;
	}

	public void setStrTeam(String strTeam){
		this.strTeam = strTeam;
	}

	public String getStrTeam(){
		return strTeam;
	}

	public void setStrTwitter(String strTwitter){
		this.strTwitter = strTwitter;
	}

	public String getStrTwitter(){
		return strTwitter;
	}

	public void setStrDescriptionHU(Object strDescriptionHU){
		this.strDescriptionHU = strDescriptionHU;
	}

	public Object getStrDescriptionHU(){
		return strDescriptionHU;
	}

	public void setStrGender(String strGender){
		this.strGender = strGender;
	}

	public String getStrGender(){
		return strGender;
	}

	public void setStrDivision(Object strDivision){
		this.strDivision = strDivision;
	}

	public Object getStrDivision(){
		return strDivision;
	}

	public void setStrStadium(String strStadium){
		this.strStadium = strStadium;
	}

	public String getStrStadium(){
		return strStadium;
	}

	public void setStrFacebook(String strFacebook){
		this.strFacebook = strFacebook;
	}

	public String getStrFacebook(){
		return strFacebook;
	}

	public void setStrTeamBadge(String strTeamBadge){
		this.strTeamBadge = strTeamBadge;
	}

	public String getStrTeamBadge(){
		return strTeamBadge;
	}

	public void setStrDescriptionPT(Object strDescriptionPT){
		this.strDescriptionPT = strDescriptionPT;
	}

	public Object getStrDescriptionPT(){
		return strDescriptionPT;
	}

	public void setStrDescriptionDE(String strDescriptionDE){
		this.strDescriptionDE = strDescriptionDE;
	}

	public String getStrDescriptionDE(){
		return strDescriptionDE;
	}

	public void setStrLeague(String strLeague){
		this.strLeague = strLeague;
	}

	public String getStrLeague(){
		return strLeague;
	}

	public void setStrManager(String strManager){
		this.strManager = strManager;
	}

	public String getStrManager(){
		return strManager;
	}

	public void setStrKeywords(String strKeywords){
		this.strKeywords = strKeywords;
	}

	public String getStrKeywords(){
		return strKeywords;
	}

	public void setStrDescriptionPL(Object strDescriptionPL){
		this.strDescriptionPL = strDescriptionPL;
	}

	public Object getStrDescriptionPL(){
		return strDescriptionPL;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(intStadiumCapacity);
		parcel.writeString(strTeamShort);
		parcel.writeString(strSport);
		parcel.writeString(strTeamJersey);
		parcel.writeString(strTeamFanart2);
		parcel.writeString(strTeamFanart3);
		parcel.writeString(strTeamFanart4);
		parcel.writeString(strStadiumDescription);
		parcel.writeString(strTeamFanart1);
		parcel.writeString(intLoved);
		parcel.writeString(idLeague);
		parcel.writeString(idSoccerXML);
		parcel.writeString(strTeamLogo);
		parcel.writeString(strStadiumLocation);
		parcel.writeString(strCountry);
		parcel.writeString(strRSS);
		parcel.writeString(strTeamBanner);
		parcel.writeString(strStadiumThumb);
		parcel.writeString(intFormedYear);
		parcel.writeString(strInstagram);
		parcel.writeString(strDescriptionIT);
		parcel.writeString(idTeam);
		parcel.writeString(strDescriptionEN);
		parcel.writeString(strWebsite);
		parcel.writeString(strYoutube);
		parcel.writeString(strLocked);
		parcel.writeString(strAlternate);
		parcel.writeString(strTeam);
		parcel.writeString(strTwitter);
		parcel.writeString(strGender);
		parcel.writeString(strStadium);
		parcel.writeString(strFacebook);
		parcel.writeString(strTeamBadge);
		parcel.writeString(strDescriptionDE);
		parcel.writeString(strLeague);
		parcel.writeString(strManager);
		parcel.writeString(strKeywords);
		parcel.writeByte((byte) (isFavorite ? 1 : 0));
		parcel.writeTypedList(teamEvents);
	}
}