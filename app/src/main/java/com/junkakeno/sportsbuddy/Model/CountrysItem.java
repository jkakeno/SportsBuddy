package com.junkakeno.sportsbuddy.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CountrysItem{

	@SerializedName("strDescriptionES")
	@Expose
	private String strDescriptionES;

	@SerializedName("dateFirstEvent")
	@Expose
	private String dateFirstEvent;

	@SerializedName("intFormedYear")
	@Expose
	private String intFormedYear;

	@SerializedName("strBanner")
	@Expose
	private Object strBanner;

	@SerializedName("strSport")
	@Expose
	private String strSport;

	@SerializedName("strDescriptionIT")
	@Expose
	private Object strDescriptionIT;

	@SerializedName("strDescriptionCN")
	@Expose
	private Object strDescriptionCN;

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

	@SerializedName("idCup")
	@Expose
	private String idCup;

	@SerializedName("strComplete")
	@Expose
	private Object strComplete;

	@SerializedName("strLocked")
	@Expose
	private String strLocked;

	@SerializedName("idLeague")
	@Expose
	private String idLeague;

	@SerializedName("idSoccerXML")
	@Expose
	private Object idSoccerXML;

	@SerializedName("strTrophy")
	@Expose
	private String strTrophy;

	@SerializedName("strBadge")
	@Expose
	private String strBadge;

	@SerializedName("strTwitter")
	@Expose
	private String strTwitter;

	@SerializedName("strDescriptionHU")
	@Expose
	private Object strDescriptionHU;

	@SerializedName("strGender")
	@Expose
	private String strGender;

	@SerializedName("strLeagueAlternate")
	@Expose
	private String strLeagueAlternate;

	@SerializedName("strDescriptionSE")
	@Expose
	private Object strDescriptionSE;

	@SerializedName("strNaming")
	@Expose
	private String strNaming;

	@SerializedName("strDivision")
	@Expose
	private String strDivision;

	@SerializedName("strDescriptionJP")
	@Expose
	private Object strDescriptionJP;

	@SerializedName("strFanart1")
	@Expose
	private String strFanart1;

	@SerializedName("strDescriptionFR")
	@Expose
	private String strDescriptionFR;

	@SerializedName("strFanart2")
	@Expose
	private Object strFanart2;

	@SerializedName("strFanart3")
	@Expose
	private Object strFanart3;

	@SerializedName("strFacebook")
	@Expose
	private String strFacebook;

	@SerializedName("strFanart4")
	@Expose
	private Object strFanart4;

	@SerializedName("strCountry")
	@Expose
	private String strCountry;

	@SerializedName("strDescriptionNL")
	@Expose
	private Object strDescriptionNL;

	@SerializedName("strRSS")
	@Expose
	private String strRSS;

	@SerializedName("strDescriptionRU")
	@Expose
	private Object strDescriptionRU;

	@SerializedName("strDescriptionPT")
	@Expose
	private Object strDescriptionPT;

	@SerializedName("strLogo")
	@Expose
	private String strLogo;

	@SerializedName("strDescriptionDE")
	@Expose
	private Object strDescriptionDE;

	@SerializedName("strDescriptionNO")
	@Expose
	private Object strDescriptionNO;

	@SerializedName("strLeague")
	@Expose
	private String strLeague;

	@SerializedName("strPoster")
	@Expose
	private Object strPoster;

	@SerializedName("strDescriptionPL")
	@Expose
	private Object strDescriptionPL;

	List<TeamsItem> teams;

	public List<TeamsItem> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamsItem> teams) {
		this.teams = teams;
	}

	public void setStrDescriptionES(String strDescriptionES){
		this.strDescriptionES = strDescriptionES;
	}

	public String getStrDescriptionES(){
		return strDescriptionES;
	}

	public void setDateFirstEvent(String dateFirstEvent){
		this.dateFirstEvent = dateFirstEvent;
	}

	public String getDateFirstEvent(){
		return dateFirstEvent;
	}

	public void setIntFormedYear(String intFormedYear){
		this.intFormedYear = intFormedYear;
	}

	public String getIntFormedYear(){
		return intFormedYear;
	}

	public void setStrBanner(Object strBanner){
		this.strBanner = strBanner;
	}

	public Object getStrBanner(){
		return strBanner;
	}

	public void setStrSport(String strSport){
		this.strSport = strSport;
	}

	public String getStrSport(){
		return strSport;
	}

	public void setStrDescriptionIT(Object strDescriptionIT){
		this.strDescriptionIT = strDescriptionIT;
	}

	public Object getStrDescriptionIT(){
		return strDescriptionIT;
	}

	public void setStrDescriptionCN(Object strDescriptionCN){
		this.strDescriptionCN = strDescriptionCN;
	}

	public Object getStrDescriptionCN(){
		return strDescriptionCN;
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

	public void setIdCup(String idCup){
		this.idCup = idCup;
	}

	public String getIdCup(){
		return idCup;
	}

	public void setStrComplete(Object strComplete){
		this.strComplete = strComplete;
	}

	public Object getStrComplete(){
		return strComplete;
	}

	public void setStrLocked(String strLocked){
		this.strLocked = strLocked;
	}

	public String getStrLocked(){
		return strLocked;
	}

	public void setIdLeague(String idLeague){
		this.idLeague = idLeague;
	}

	public String getIdLeague(){
		return idLeague;
	}

	public void setIdSoccerXML(Object idSoccerXML){
		this.idSoccerXML = idSoccerXML;
	}

	public Object getIdSoccerXML(){
		return idSoccerXML;
	}

	public void setStrTrophy(String strTrophy){
		this.strTrophy = strTrophy;
	}

	public String getStrTrophy(){
		return strTrophy;
	}

	public void setStrBadge(String strBadge){
		this.strBadge = strBadge;
	}

	public String getStrBadge(){
		return strBadge;
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

	public void setStrLeagueAlternate(String strLeagueAlternate){
		this.strLeagueAlternate = strLeagueAlternate;
	}

	public String getStrLeagueAlternate(){
		return strLeagueAlternate;
	}

	public void setStrDescriptionSE(Object strDescriptionSE){
		this.strDescriptionSE = strDescriptionSE;
	}

	public Object getStrDescriptionSE(){
		return strDescriptionSE;
	}

	public void setStrNaming(String strNaming){
		this.strNaming = strNaming;
	}

	public String getStrNaming(){
		return strNaming;
	}

	public void setStrDivision(String strDivision){
		this.strDivision = strDivision;
	}

	public String getStrDivision(){
		return strDivision;
	}

	public void setStrDescriptionJP(Object strDescriptionJP){
		this.strDescriptionJP = strDescriptionJP;
	}

	public Object getStrDescriptionJP(){
		return strDescriptionJP;
	}

	public void setStrFanart1(String strFanart1){
		this.strFanart1 = strFanart1;
	}

	public String getStrFanart1(){
		return strFanart1;
	}

	public void setStrDescriptionFR(String strDescriptionFR){
		this.strDescriptionFR = strDescriptionFR;
	}

	public String getStrDescriptionFR(){
		return strDescriptionFR;
	}

	public void setStrFanart2(Object strFanart2){
		this.strFanart2 = strFanart2;
	}

	public Object getStrFanart2(){
		return strFanart2;
	}

	public void setStrFanart3(Object strFanart3){
		this.strFanart3 = strFanart3;
	}

	public Object getStrFanart3(){
		return strFanart3;
	}

	public void setStrFacebook(String strFacebook){
		this.strFacebook = strFacebook;
	}

	public String getStrFacebook(){
		return strFacebook;
	}

	public void setStrFanart4(Object strFanart4){
		this.strFanart4 = strFanart4;
	}

	public Object getStrFanart4(){
		return strFanart4;
	}

	public void setStrCountry(String strCountry){
		this.strCountry = strCountry;
	}

	public String getStrCountry(){
		return strCountry;
	}

	public void setStrDescriptionNL(Object strDescriptionNL){
		this.strDescriptionNL = strDescriptionNL;
	}

	public Object getStrDescriptionNL(){
		return strDescriptionNL;
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

	public void setStrDescriptionPT(Object strDescriptionPT){
		this.strDescriptionPT = strDescriptionPT;
	}

	public Object getStrDescriptionPT(){
		return strDescriptionPT;
	}

	public void setStrLogo(String strLogo){
		this.strLogo = strLogo;
	}

	public String getStrLogo(){
		return strLogo;
	}

	public void setStrDescriptionDE(Object strDescriptionDE){
		this.strDescriptionDE = strDescriptionDE;
	}

	public Object getStrDescriptionDE(){
		return strDescriptionDE;
	}

	public void setStrDescriptionNO(Object strDescriptionNO){
		this.strDescriptionNO = strDescriptionNO;
	}

	public Object getStrDescriptionNO(){
		return strDescriptionNO;
	}

	public void setStrLeague(String strLeague){
		this.strLeague = strLeague;
	}

	public String getStrLeague(){
		return strLeague;
	}

	public void setStrPoster(Object strPoster){
		this.strPoster = strPoster;
	}

	public Object getStrPoster(){
		return strPoster;
	}

	public void setStrDescriptionPL(Object strDescriptionPL){
		this.strDescriptionPL = strDescriptionPL;
	}

	public Object getStrDescriptionPL(){
		return strDescriptionPL;
	}
}