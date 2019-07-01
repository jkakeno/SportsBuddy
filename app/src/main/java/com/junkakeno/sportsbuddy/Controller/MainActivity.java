package com.junkakeno.sportsbuddy.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.EventsItem;
import com.junkakeno.sportsbuddy.Model.Leagues;
import com.junkakeno.sportsbuddy.Model.LeaguesItem;
import com.junkakeno.sportsbuddy.Model.Seasons;
import com.junkakeno.sportsbuddy.Model.SeasonsItem;
import com.junkakeno.sportsbuddy.Model.Sports;
import com.junkakeno.sportsbuddy.Model.SportsItem;
import com.junkakeno.sportsbuddy.Model.Teams;
import com.junkakeno.sportsbuddy.Model.TeamsItem;
import com.junkakeno.sportsbuddy.Network.ApiInterface;
import com.junkakeno.sportsbuddy.Network.ApiUtils;
import com.junkakeno.sportsbuddy.R;
import com.junkakeno.sportsbuddy.View.EventListAdapter;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    ApiInterface apiInterface;
    Sports sportsList;
    Seasons seasonsList;
    Leagues leaguesList;
    Teams teamsList;
    Events eventsList;
    Spinner sportSpinner;
    Spinner leagueSpinner;
    Spinner teamSpinner;
    Spinner seasonSpinner;
    ArrayAdapter<String> sport_list_adapter;
    ArrayAdapter<String> league_list_adapter;
    ArrayAdapter<String> team_list_adapter;
    ArrayAdapter<String> season_list_adapter;
    String sport;
    ArrayList<String> leagues;
    String league;
    ArrayList<String> teams;
    String team;
    ArrayList<String> seasons;
    String season;
    String seasonId;
    String leagueId;

    RecyclerView recyclerView;
    EventListAdapter adapter;
    LinearLayoutManager layoutManager;
    TextView noItemMsg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sportSpinner = findViewById(R.id.sport_spinner);
        leagueSpinner = findViewById(R.id.league_spinner);
        teamSpinner = findViewById(R.id.team_spinner);
        seasonSpinner = findViewById(R.id.season_spinner);
        recyclerView = findViewById(R.id.recycler_view);
        noItemMsg = findViewById(R.id.no_items_msg);
        noItemMsg.setVisibility(View.INVISIBLE);

        sportSpinner.setOnItemSelectedListener(this);
        leagueSpinner.setOnItemSelectedListener(this);
        teamSpinner.setOnItemSelectedListener(this);
        seasonSpinner.setOnItemSelectedListener(this);

        apiInterface = ApiUtils.thesportsdbInterface();

        apiInterface.getSports().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Sports>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Sports sports) {
                sportsList = sports;
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                ArrayList<String> sportsName = new ArrayList<>();
                for (SportsItem sports:sportsList.getSports()){
                    sportsName.add(sports.getStrSport());
                }
                sport_list_adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, sportsName);
                sport_list_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sportSpinner.setAdapter(sport_list_adapter);
            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

        switch (adapterView.getId()) {
            case R.id.sport_spinner:
                Log.d(TAG, "Sport spinner");
                sport = adapterView.getItemAtPosition(position).toString();

                Observable.just(sport).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "Sport selection changed to: " + sport);


                        apiInterface.getLeagues().subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Leagues>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Leagues leagues) {
                                leaguesList = leagues;
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                leagues = new ArrayList<>();
                                for (LeaguesItem league : leaguesList.getLeagues()) {
                                    if (sport.equals(league.getStrSport())) {
                                        leagues.add(league.getStrLeague());
                                    }
                                }

                                league_list_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, leagues);
                                league_list_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                leagueSpinner.setAdapter(league_list_adapter);

                            }
                        });

                    }
                });


                break;
            case R.id.league_spinner:
                Log.d(TAG, "League spinner");
                league = adapterView.getItemAtPosition(position).toString();

                for (LeaguesItem leaguesItem : leaguesList.getLeagues()) {
                    if (leaguesItem.getStrLeague().equals(league)) {
                        leagueId = leaguesItem.getIdLeague();
                    }
                }

                Observable.just(league).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "League selection changed to: " + league);


                        for (LeaguesItem leaguesItem : leaguesList.getLeagues()) {
                            if (leaguesItem.getStrLeague().equals(league)) {
                                Log.d(TAG, leaguesItem.getIdLeague());

                                apiInterface.getTeams(leaguesItem.getIdLeague()).subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Teams>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(Teams teams) {
                                        teamsList = teams;
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onComplete() {
                                        teams = new ArrayList<>();
                                        teams.add("All Teams");
                                        for (TeamsItem teamsItem : teamsList.getTeams()) {
                                            teams.add(teamsItem.getStrTeam());
                                        }
                                        team_list_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, teams);
                                        team_list_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        teamSpinner.setAdapter(team_list_adapter);
                                    }
                                });

                                apiInterface.getSeasons(leaguesItem.getIdLeague()).subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Seasons>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(Seasons seasons) {
                                        seasonsList = seasons;
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Log.d(TAG, e.getMessage());
                                    }

                                    @Override
                                    public void onComplete() {
                                        seasons = new ArrayList<>();
                                        for (SeasonsItem seasonsItem : seasonsList.getSeasons()) {
                                            seasons.add(seasonsItem.getStrSeason());
                                        }

                                        season_list_adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, seasons);
                                        season_list_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        seasonSpinner.setAdapter(season_list_adapter);

                                    }
                                });
                            }
                        }

                    }
                });
                break;
            case R.id.team_spinner:
                Log.d(TAG, "Team spinner");
                team = adapterView.getItemAtPosition(position).toString();

                if(eventsList!=null) {
                    if (!eventsList.getEvents().isEmpty()) {

                        if(team.equals("All Teams")){
                            adapter = new EventListAdapter(MainActivity.this, eventsList.getEvents());
                            layoutManager = new LinearLayoutManager(MainActivity.this);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(layoutManager);
                        }else {
                            ArrayList<EventsItem> events = new ArrayList<>();
                            for (EventsItem eventsItem : eventsList.getEvents()) {
                                if (eventsItem.getStrAwayTeam().equals(team) || eventsItem.getStrHomeTeam().equals(team)) {
                                    events.add(eventsItem);
                                }
                            }
                            adapter = new EventListAdapter(MainActivity.this, events);
                            layoutManager = new LinearLayoutManager(MainActivity.this);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(layoutManager);
                        }

                    } else {
                        noItemMsg.setVisibility(View.VISIBLE);
                    }
                }

                break;
            case R.id.season_spinner:
                Log.d(TAG, "Season spinner");
                season = adapterView.getItemAtPosition(position).toString();

                for (SeasonsItem seasonsItem : seasonsList.getSeasons()) {
                    if (seasonsItem.getStrSeason().equals(season)) {
                        seasonId = seasonsItem.getStrSeason();
                    }
                }

                apiInterface.getEvents(leagueId, seasonId).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Events>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Events events) {
                        eventsList = events;
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (!eventsList.getEvents().isEmpty()) {

                            if(team.equals("All Teams")){
                                adapter = new EventListAdapter(MainActivity.this, eventsList.getEvents());
                                layoutManager = new LinearLayoutManager(MainActivity.this);
                                recyclerView.setAdapter(adapter);
                                recyclerView.setLayoutManager(layoutManager);
                            }else {
                                ArrayList<EventsItem> events = new ArrayList<>();
                                for (EventsItem eventsItem : eventsList.getEvents()) {
                                    if (eventsItem.getStrAwayTeam().equals(team) || eventsItem.getStrHomeTeam().equals(team)) {
                                        events.add(eventsItem);
                                    }
                                }
                                adapter = new EventListAdapter(MainActivity.this, events);
                                layoutManager = new LinearLayoutManager(MainActivity.this);
                                recyclerView.setAdapter(adapter);
                                recyclerView.setLayoutManager(layoutManager);
                            }

                        } else {
                            noItemMsg.setVisibility(View.VISIBLE);
                        }
                    }
                });

                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
