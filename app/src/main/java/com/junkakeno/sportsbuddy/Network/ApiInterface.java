package com.junkakeno.sportsbuddy.Network;

import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.Leagues;
import com.junkakeno.sportsbuddy.Model.Seasons;
import com.junkakeno.sportsbuddy.Model.Sports;
import com.junkakeno.sportsbuddy.Model.Teams;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/all_sports.php")
    Observable<Sports> getSports();

    @GET("/api/v1/json/1/all_leagues.php")
    Observable<Leagues> getLeagues();

    @GET("https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php")
    Observable<Teams> getTeams(@Query("id") String leagueId);

    @GET("/api/v1/json/1/search_all_seasons.php")
    Observable<Seasons> getSeasons(@Query("id") String id);

    @GET("/api/v1/json/1/eventsseason.php")
    Observable<Events> getEvents(@Query("id") String seasonId, @Query("s") String leagueId);

}
