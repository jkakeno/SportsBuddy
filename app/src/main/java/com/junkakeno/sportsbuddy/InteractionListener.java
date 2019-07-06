package com.junkakeno.sportsbuddy;

import com.junkakeno.sportsbuddy.Model.CountrysItem;
import com.junkakeno.sportsbuddy.Model.TeamsItem;

public interface InteractionListener {

    void onSportSelectInteraction(String sport);
    void onLeagueSelectInteraction(CountrysItem league);
    void onTeamSelectInteraction(TeamsItem team);
    void onFavoriteTeamSelectInteraction(TeamsItem team);
    void onFavoriteSaveInteraction(TeamsItem team);
    void onFavoriteDeleteInteraction(TeamsItem team);
    void onBackInteraction(String tag);
    void onSeasonSelectInteraction(String season, String leagueId, TeamsItem team);
}
