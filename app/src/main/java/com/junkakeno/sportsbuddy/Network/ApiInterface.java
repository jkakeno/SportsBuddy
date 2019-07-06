package com.junkakeno.sportsbuddy.Network;

import com.junkakeno.sportsbuddy.Model.Countries;
import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.Seasons;
import com.junkakeno.sportsbuddy.Model.Sports;
import com.junkakeno.sportsbuddy.Model.Teams;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/all_sports.php")
    Call<Sports> getAllSports();

    @GET("/api/v1/json/1/search_all_leagues.php")
    Call<Countries> getLeagues(@Query("s") String sport);

    @GET("https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php")
    Observable<Teams> getLeagueTeams(@Query("id") String leagueId);

    @GET("/api/v1/json/1/search_all_seasons.php")
    Call<Seasons> getLeagueSeasons(@Query("id") String leagueId);

    @GET("/api/v1/json/1/eventsseason.php")
    Observable<Events> getLeagueEvents(@Query("id") String leagueId);

    @GET("/api/v1/json/1/eventsseason.php")
    Call<Events> getLeagueSeasonEvents(@Query("id") String leagueId, @Query("s") String seasonId);

    @GET("/api/v1/json/1/lookupteam.php")
    Observable<Teams> getTeamDetail(@Query("id") String teamId);

}
