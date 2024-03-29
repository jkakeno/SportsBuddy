package com.junkakeno.sportsbuddy.Controller;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.junkakeno.sportsbuddy.Database.Database;
import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.Countries;
import com.junkakeno.sportsbuddy.Model.CountrysItem;
import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.EventsItem;
import com.junkakeno.sportsbuddy.Model.Seasons;
import com.junkakeno.sportsbuddy.Model.Sports;
import com.junkakeno.sportsbuddy.Model.Teams;
import com.junkakeno.sportsbuddy.Model.TeamsAndEvents;
import com.junkakeno.sportsbuddy.Model.TeamsItem;
import com.junkakeno.sportsbuddy.Network.ApiInterface;
import com.junkakeno.sportsbuddy.Network.ApiUtils;
import com.junkakeno.sportsbuddy.R;
import com.junkakeno.sportsbuddy.View.FavoriteTeamDetailFragment;
import com.junkakeno.sportsbuddy.View.LeagueDetailFragment;
import com.junkakeno.sportsbuddy.View.LeagueListFragment;
import com.junkakeno.sportsbuddy.View.FavoriteListFragment;
import com.junkakeno.sportsbuddy.View.ProgressBarDialog;
import com.junkakeno.sportsbuddy.View.SportFragment;
import com.junkakeno.sportsbuddy.View.ContainerFragment;
import com.junkakeno.sportsbuddy.View.TeamDetailFragment;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements InteractionListener,BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    //1st layer
    private static final String SPLASH_FRAGMENT = "splashFragment";
    private static final String PROGRESS_DIALOG = ProgressBarDialog.class.getSimpleName();
    private static final String CONTAINER_FRAGMENT = ContainerFragment.class.getSimpleName();
    private static final String SPORT_FRAGMENT = SportFragment.class.getSimpleName();
    private static final String LEAGUE_LIST_FRAGMENT = LeagueListFragment.class.getSimpleName();
    private static final String FAVORITE_LIST_FRAGMENT = FavoriteListFragment.class.getSimpleName();
    //2nd layer
    private static final String LEAGUE_DETAIL_FRAGMENT = LeagueDetailFragment.class.getSimpleName();
    private static final String TEAM_DETAIL_FRAGMENT = TeamDetailFragment.class.getSimpleName();
    private static final String FAVORITE_TEAM_DETAIL_FRAGMENT = FavoriteTeamDetailFragment.class.getSimpleName();

    ApiInterface apiInterface;
    Sports sportsList;
    Seasons seasonsList;
    Countries leaguesList;
    Teams teamsList;
    Events eventsList;
    String sport;
    FragmentManager fragmentManager;
    Disposable teamsAndEventsDisposable;
    Disposable favoriteTeamsDisposable;
    ActionBar actionBar;
    Database db;
    ArrayList<String> favoriteList;
    ArrayList<TeamsItem> favoriteTeams;
    ProgressBarDialog progressDialog = new ProgressBarDialog();
    final boolean[] progressDialogIsShowing = new boolean[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiUtils.thesportsdbInterface();

        fragmentManager = getSupportFragmentManager();

        db = new Database(this);

        favoriteList = db.getFavorites();

        progressDialog.show(fragmentManager,PROGRESS_DIALOG);
        progressDialogIsShowing[0] =true;

        ContainerFragment containerFragment = new ContainerFragment();
        fragmentManager.beginTransaction().replace(R.id.root, containerFragment, CONTAINER_FRAGMENT)
                .addToBackStack(null).commit();

        apiInterface.getAllSports().enqueue(new Callback<Sports>() {
            @Override
            public void onResponse(Call<Sports> call, Response<Sports> response) {
                if(response.isSuccessful()){
                    sportsList = response.body();
                    progressDialog.cancel();
                    progressDialogIsShowing[0] = false;
                    setupHomeScreen(sportsList.getDefaultSport());
                }else{
                    showDialog(getResources().getString(R.string.error_type),
                            getResources().getString(R.string.api_response_not_successful_msg));
                    progressDialog.cancel();
                    progressDialogIsShowing[0] = false;
                }
            }

            @Override
            public void onFailure(Call<Sports> call, Throwable t) {
                showDialog(getResources().getString(R.string.error_type),
                        getResources().getString(R.string.api_call_error_msg)+t.getMessage());
                progressDialog.cancel();
                progressDialogIsShowing[0] = false;
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(teamsAndEventsDisposable != null){
            teamsAndEventsDisposable.dispose();
        }
        if(favoriteTeamsDisposable !=null){
            favoriteTeamsDisposable.dispose();
        }
    }

    //To solve Transaction Too Large Exception when presing home button
    //https://stackoverflow.com/questions/39098590/android-os-transactiontoolargeexception-on-nougat
    @Override
    protected void onSaveInstanceState(Bundle oldInstanceState) {
        super.onSaveInstanceState(oldInstanceState);
        oldInstanceState.clear();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Log.d(TAG,"Home selected");

                if(sport!=null){
                    setupHomeScreen(sport);
                }else{
                    setupHomeScreen(sportsList.getDefaultSport());
                }

                return true;
            case R.id.navigation_favorite:
                Log.d(TAG,"Favorite selected");

                setupFavoriteScreen();

                return true;
        }
        return false;
    }

    @Override
    public void onSportSelectInteraction(String sport) {
        Log.d(TAG,"Selected: " + sport);
        this.sport = sport;
        updateHomeScreen(sport);
    }

    @Override
    public void onLeagueSelectInteraction(CountrysItem league) {
        Log.d(TAG,"Selected: " + league.getStrLeague() + " id: " + league.getIdLeague());

        if(!progressDialogIsShowing[0]){
            progressDialog.show(fragmentManager, PROGRESS_DIALOG);
            progressDialogIsShowing[0] =true;
        }

        //Get the selected league's teams and events
        Observable<Teams> teamsObservable = apiInterface.getLeagueTeams(league.getIdLeague())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Observable<Events> eventsObservable = apiInterface.getLeagueEvents(league.getIdLeague())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Observable<TeamsAndEvents> combinedObservable = Observable
                .zip(teamsObservable, eventsObservable, new BiFunction<Teams, Events, TeamsAndEvents>() {
            @Override
            public TeamsAndEvents apply(Teams teams, Events events) throws Exception {
                return new TeamsAndEvents(teams,events);
            }
        });

        /*Create an anonymous observer to observe the combine observables.*/
        combinedObservable.subscribe(new Observer<TeamsAndEvents>() {
             @Override
             public void onSubscribe(Disposable d) {
                teamsAndEventsDisposable = d;
             }

             @Override
             public void onNext(TeamsAndEvents teamsAndEvents) {
                 if(teamsList!=null) {
                     teamsList.resetTeams();
                 }
                 if(eventsList!=null) {
                     eventsList.resetEvents();
                 }
                teamsList = teamsAndEvents.getTeams();
                eventsList = teamsAndEvents.getEvents();
             }

             @Override
             public void onError(Throwable e) {
                 showDialog(getResources().getString(R.string.error_type),
                         getResources().getString(R.string.api_call_error_msg)+e.getMessage());
                 progressDialog.cancel();
                 progressDialogIsShowing[0] =false;
             }

             @Override
             public void onComplete() {

                 if(teamsList.getTeams()!=null && eventsList.getEvents()!=null) {

                     setTeamsBadges();

                     Fragment containerFragment = fragmentManager.findFragmentByTag(CONTAINER_FRAGMENT);
                     LeagueDetailFragment leagueDetailFragment = LeagueDetailFragment
                             .newInstance(teamsList,eventsList);
                     fragmentManager.beginTransaction()
                             .replace(containerFragment.getId(), leagueDetailFragment, LEAGUE_DETAIL_FRAGMENT)
                             .addToBackStack(CONTAINER_FRAGMENT).commit();
                     actionBar.hide();
                     progressDialog.cancel();
                     progressDialogIsShowing[0] =false;
                 }else{
                     showDialog(getResources().getString(R.string.info_type),
                             getResources().getString(R.string.no_content_msg));
                     progressDialog.cancel();
                     progressDialogIsShowing[0] =false;
                 }

             }
        });

    }

    @Override
    public void onSeasonSelectInteraction(String season, String leagueId, final TeamsItem team) {
        if(!progressDialogIsShowing[0]){
            progressDialog.show(fragmentManager, PROGRESS_DIALOG);
            progressDialogIsShowing[0] =true;
        }

        apiInterface.getLeagueSeasonEvents(leagueId,season).enqueue(new Callback<Events>() {
            @Override
            public void onResponse(Call<Events> call, Response<Events> response) {
                if(response.isSuccessful()){

                    eventsList = response.body();

                    //NOTE: Using Event object helper method to filter the events only containing the selected team
                    eventsList.setTeamEvents(team);

                    setTeamsBadges();

                    Fragment teamDetailFrg = fragmentManager.findFragmentByTag(TEAM_DETAIL_FRAGMENT);
                    Fragment favoriteTeamDetailFrg = fragmentManager.findFragmentByTag(FAVORITE_TEAM_DETAIL_FRAGMENT);

                    if(teamDetailFrg!=null&&teamDetailFrg.isVisible()) {
                        Fragment leagueDetailFragment = fragmentManager.findFragmentByTag(LEAGUE_DETAIL_FRAGMENT);
                        Fragment teamDetailFragment = TeamDetailFragment.newInstance(team, eventsList, seasonsList);
                        fragmentManager.beginTransaction()
                                .replace(leagueDetailFragment.getId(), teamDetailFragment, TEAM_DETAIL_FRAGMENT)
                                .addToBackStack(LEAGUE_DETAIL_FRAGMENT).commit();
                        progressDialog.cancel();
                        progressDialogIsShowing[0] =false;
                    }

                    if(favoriteTeamDetailFrg!=null&&favoriteTeamDetailFrg.isVisible()) {
                        Fragment favoriteListFragment = fragmentManager.findFragmentByTag(FAVORITE_LIST_FRAGMENT);
                        Fragment favoriteTeamDetailFragment = FavoriteTeamDetailFragment.newInstance(team, eventsList, seasonsList);
                        fragmentManager.beginTransaction()
                                .replace(favoriteListFragment.getId(), favoriteTeamDetailFragment, FAVORITE_TEAM_DETAIL_FRAGMENT)
                                .addToBackStack(FAVORITE_LIST_FRAGMENT).commit();
                        actionBar.hide();
                        progressDialog.cancel();
                        progressDialogIsShowing[0] =false;
                    }
                }else{
                    showDialog(getResources().getString(R.string.error_type),
                            getResources().getString(R.string.api_response_not_successful_msg));
                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;
                }
            }

            @Override
            public void onFailure(Call<Events> call, Throwable t) {
                showDialog(getResources().getString(R.string.error_type),
                        getResources().getString(R.string.api_call_error_msg)+t.getMessage());
                progressDialog.cancel();
                progressDialogIsShowing[0] =false;
            }
        });
    }

    @Override
    public void onTeamSelectInteraction(final TeamsItem team) {
        Log.d(TAG,"Selected: " + team.getStrTeam() + " id: " + team.getIdTeam());
        if(!progressDialogIsShowing[0]){
            progressDialog.show(fragmentManager, PROGRESS_DIALOG);
            progressDialogIsShowing[0] =true;
        }
        apiInterface.getLeagueSeasons(team.getIdLeague()).enqueue(new Callback<Seasons>() {
            @Override
            public void onResponse(Call<Seasons> call, Response<Seasons> response) {
                if(response.isSuccessful()){
                    seasonsList = response.body();

                    //NOTE: Using Event object helper method to filter the events only containing the selected team
                    eventsList.setTeamEvents(team);

                    setTeamsBadges();

                    setTeamFavoriteStatus(team);

                    Fragment leagueDetailFragment = fragmentManager.findFragmentByTag(LEAGUE_DETAIL_FRAGMENT);
                    Fragment teamDetailFragment = TeamDetailFragment.newInstance(team,eventsList,seasonsList);
                    fragmentManager.beginTransaction()
                            .replace(leagueDetailFragment.getId(),teamDetailFragment,TEAM_DETAIL_FRAGMENT)
                            .addToBackStack(LEAGUE_DETAIL_FRAGMENT).commit();

                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;

                }else{
                    showDialog(getResources().getString(R.string.error_type),
                            getResources().getString(R.string.api_response_not_successful_msg));
                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;
                }
            }

            @Override
            public void onFailure(Call<Seasons> call, Throwable t) {
                showDialog(getResources().getString(R.string.error_type),
                        getResources().getString(R.string.api_call_error_msg)+t.getMessage());
                progressDialog.cancel();
                progressDialogIsShowing[0] =false;
            }
        });
    }

    @Override
    public void onFavoriteSaveInteraction(TeamsItem team) {
        Log.d(TAG, "Save favorite: " + team.getStrTeam());

        favoriteList = db.getFavorites();

        if (favoriteList.size() < 3) {
            db.saveFavorite(team.getIdTeam());
        } else {
            if(db.getSubscription().isEmpty()) {
                showDialog(getResources().getString(R.string.subscribe_type), getResources().getString(R.string.subscription_msg));
            }else if(db.getSubscription().get(0).equals(getResources().getString(R.string.subscription_key))){
                db.saveFavorite(team.getIdTeam());
            }
        }

    }

    @Override
    public void onFavoriteDeleteInteraction(TeamsItem team) {
        Log.d(TAG,"Delete favorite: " + team.getStrTeam());

        db.deleteFavorite(team.getIdTeam());
    }

    @Override
    public void onFavoriteTeamSelectInteraction(final TeamsItem team) {
        Log.d(TAG,"Selected: " + team.getStrTeam());

        if(!progressDialogIsShowing[0]){
            progressDialog.show(fragmentManager, PROGRESS_DIALOG);
            progressDialogIsShowing[0] =true;
        }

        //Get the selected league's teams and events
        Observable<Teams> teamsObservable = apiInterface.getLeagueTeams(team.getIdLeague())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Observable<Events> eventsObservable = apiInterface.getLeagueEvents(team.getIdLeague())
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Observable<TeamsAndEvents> combinedObservable = Observable
                .zip(teamsObservable, eventsObservable, new BiFunction<Teams, Events, TeamsAndEvents>() {
            @Override
            public TeamsAndEvents apply(Teams teams, Events events) throws Exception {
                return new TeamsAndEvents(teams,events);
            }
        });

        /*Create an anonymous observer to observe the combine observables.*/
        combinedObservable.subscribe(new Observer<TeamsAndEvents>() {
            @Override
            public void onSubscribe(Disposable d) {
                teamsAndEventsDisposable = d;
            }

            @Override
            public void onNext(TeamsAndEvents teamsAndEvents) {
                if(teamsList!=null) {
                    teamsList.resetTeams();
                }
                if(eventsList!=null) {
                    eventsList.resetEvents();
                }
                teamsList = teamsAndEvents.getTeams();
                eventsList = teamsAndEvents.getEvents();
            }

            @Override
            public void onError(Throwable e) {
                showDialog(getResources().getString(R.string.error_type),
                        getResources().getString(R.string.api_call_error_msg)+e.getMessage());
                progressDialog.cancel();
                progressDialogIsShowing[0] =false;
            }

            @Override
            public void onComplete() {
                if(teamsList.getTeams()!=null && eventsList.getEvents()!=null) {

                    apiInterface.getLeagueSeasons(team.getIdLeague()).enqueue(new Callback<Seasons>() {
                        @Override
                        public void onResponse(Call<Seasons> call, Response<Seasons> response) {
                            if(response.isSuccessful()){
                                seasonsList = response.body();

                                //NOTE: Using Event object helper method to filter the events only containing the selected team
                                eventsList.setTeamEvents(team);

                                setTeamsBadges();

                                setTeamFavoriteStatus(team);

                                Fragment favoriteListFragment = fragmentManager.findFragmentByTag(FAVORITE_LIST_FRAGMENT);
                                Fragment favoriteTeamDetailFragment = FavoriteTeamDetailFragment.newInstance(team,eventsList,seasonsList);
                                fragmentManager.beginTransaction()
                                        .replace(favoriteListFragment.getId(),favoriteTeamDetailFragment,FAVORITE_TEAM_DETAIL_FRAGMENT)
                                        .addToBackStack(FAVORITE_LIST_FRAGMENT).commit();
                                actionBar.hide();

                                progressDialog.cancel();
                                progressDialogIsShowing[0] =false;

                            }else{
                                showDialog(getResources().getString(R.string.error_type),
                                        getResources().getString(R.string.api_response_not_successful_msg));
                                progressDialog.cancel();
                                progressDialogIsShowing[0] =false;
                            }
                        }

                        @Override
                        public void onFailure(Call<Seasons> call, Throwable t) {
                            showDialog(getResources().getString(R.string.error_type),
                                    getResources().getString(R.string.api_call_error_msg)+t.getMessage());
                            progressDialog.cancel();
                            progressDialogIsShowing[0] =false;
                        }
                    });



                }else{
                    showDialog(getResources().getString(R.string.info_type),
                            getResources().getString(R.string.no_content_msg));
                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;
                }
            }
        });

    }

    @Override
    public void onBackInteraction(String tag) {
        Log.d(TAG,"Go back");
        if(tag.equals(LEAGUE_DETAIL_FRAGMENT)){
            if(sport!=null){
                setupHomeScreen(sport);
            }else{
                setupHomeScreen(sportsList.getDefaultSport());
            }

        }

    }

    @Override
    public void onBackPressed() {
        Log.d(TAG,"Go back");
        Fragment leagueListFragment = fragmentManager.findFragmentByTag(LEAGUE_LIST_FRAGMENT);
        Fragment favoriteListFragment = fragmentManager.findFragmentByTag(FAVORITE_LIST_FRAGMENT);
        Fragment leagueDetailFragment = fragmentManager.findFragmentByTag(LEAGUE_DETAIL_FRAGMENT);
        Fragment teamDetailFragment = fragmentManager.findFragmentByTag(TEAM_DETAIL_FRAGMENT);
        Fragment favoriteTeamDetailFragment = fragmentManager.findFragmentByTag(FAVORITE_TEAM_DETAIL_FRAGMENT);

        if(leagueListFragment!=null && leagueListFragment.isVisible()){
            finish();
        }
        if(favoriteListFragment!=null && favoriteListFragment.isVisible()){
            finish();
        }
        if(leagueDetailFragment !=null && leagueDetailFragment.isVisible()){
            if(sport!=null){
                setupHomeScreen(sport);
            }else{
                setupHomeScreen(sportsList.getDefaultSport());
            }
        }
        if(teamDetailFragment!=null&&teamDetailFragment.isVisible()){

            Fragment containerFragment = fragmentManager.findFragmentByTag(CONTAINER_FRAGMENT);
            LeagueDetailFragment leagueDetailFragment2 = LeagueDetailFragment.newInstance(teamsList,eventsList);
            fragmentManager.beginTransaction()
                    .replace(containerFragment.getId(), leagueDetailFragment2, LEAGUE_DETAIL_FRAGMENT)
                    .addToBackStack(CONTAINER_FRAGMENT).commit();

        }
        if(favoriteTeamDetailFragment!=null&&favoriteTeamDetailFragment.isVisible()){
            setupFavoriteScreen();
        }
    }

    private void setTeamFavoriteStatus(TeamsItem team) {
        ArrayList<String> favorites = db.getFavorites();

        for(String teamId: favorites){
            if(team.getIdTeam().equals(teamId)){
                team.setFavorite(true);
            }
        }
    }

    public void setupHomeScreen(String sport){
        if(!progressDialogIsShowing[0]){
            progressDialog.show(fragmentManager, PROGRESS_DIALOG);
            progressDialogIsShowing[0] =true;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.show();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        Fragment containerFragment = fragmentManager.findFragmentByTag(CONTAINER_FRAGMENT);
        fragmentManager.beginTransaction().replace(R.id.root, containerFragment, CONTAINER_FRAGMENT).commit();

        SportFragment sportFragment = SportFragment.newInstance(sportsList.getSelectedSports());
        fragmentManager.beginTransaction().add(R.id.upper_container, sportFragment, SPORT_FRAGMENT).commit();

        apiInterface.getLeagues(sport).enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(Call<Countries> call, Response<Countries> response) {
                if(response.isSuccessful()){
                    leaguesList=response.body();
                    LeagueListFragment leagueListFragment = LeagueListFragment.newInstance(leaguesList);
                    fragmentManager.beginTransaction()
                            .replace(R.id.lower_container, leagueListFragment, LEAGUE_LIST_FRAGMENT)
                            .addToBackStack(null).commit();
                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;
                }else{
                    showDialog(getResources().getString(R.string.error_type),
                            getResources().getString(R.string.api_response_not_successful_msg));
                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;
                }
            }

            @Override
            public void onFailure(Call<Countries> call, Throwable t) {
                showDialog(getResources().getString(R.string.error_type),
                        getResources().getString(R.string.api_call_error_msg)+t.getMessage());
                progressDialog.cancel();
                progressDialogIsShowing[0] =false;
            }
        });
    }

    public void updateHomeScreen(String sport){
        Fragment progress = fragmentManager.findFragmentByTag(PROGRESS_DIALOG);
        if(progress!=null&&!progress.isAdded()) {
            progressDialog.show(fragmentManager, PROGRESS_DIALOG);
            progressDialogIsShowing[0] =true;
        }
        apiInterface.getLeagues(sport).enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(Call<Countries> call, Response<Countries> response) {
                if(response.isSuccessful()) {
                    leaguesList=response.body();
                    LeagueListFragment leagueListFragment = LeagueListFragment.newInstance(leaguesList);
                    fragmentManager.beginTransaction()
                            .replace(R.id.lower_container, leagueListFragment, LEAGUE_LIST_FRAGMENT).commit();
                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;
                }else{
                    showDialog(getResources().getString(R.string.error_type),
                            getResources().getString(R.string.api_response_not_successful_msg));
                    progressDialog.cancel();
                    progressDialogIsShowing[0] =false;
                }
            }

            @Override
            public void onFailure(Call<Countries> call, Throwable t) {
                showDialog(getResources().getString(R.string.error_type),
                        getResources().getString(R.string.api_call_error_msg)+t.getMessage());
                progressDialog.cancel();
                progressDialogIsShowing[0] =false;
            }
        });

    }

    private void setupFavoriteScreen() {
        if(!progressDialogIsShowing[0]){
            progressDialog.show(fragmentManager, PROGRESS_DIALOG);
            progressDialogIsShowing[0] =true;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.show();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);

        final Fragment containerFragment = fragmentManager.findFragmentByTag(CONTAINER_FRAGMENT);
        final int containerFragmentId = containerFragment.getId();
        fragmentManager.beginTransaction().replace(R.id.root, containerFragment, CONTAINER_FRAGMENT).commit();

        favoriteList = db.getFavorites();
        favoriteTeams = new ArrayList<>();

        Observable.fromIterable(favoriteList).concatMap(new Function<String, ObservableSource<Teams>>() {
            @Override
            public ObservableSource<Teams> apply(String teamId) throws Exception {
                return apiInterface.getTeamDetail(teamId).map(new Function<Teams, Teams>() {
                    @Override
                    public Teams apply(Teams teams) throws Exception {
                        return teams;
                    }
                });
            }
        }).subscribe(new Observer<Teams>() {
            @Override
            public void onSubscribe(Disposable d) {
                favoriteTeamsDisposable = d;
            }

            @Override
            public void onNext(Teams teams) {
                TeamsItem team = teams.getTeams().get(0);
                Log.d(TAG,"Got: " + team.getStrTeam());

                favoriteTeams.add(team);
            }

            @Override
            public void onError(final Throwable e) {
                new Thread()
                {
                    public void run()
                    {
                        MainActivity.this.runOnUiThread(new Runnable()
                        {
                            public void run()
                            {
                                //Do your UI operations like dialog opening or Toast here
                                showDialog(getResources().getString(R.string.error_type),
                                        getResources().getString(R.string.api_call_error_msg)+e.getMessage());
                                progressDialog.cancel();
                                progressDialogIsShowing[0] =false;
                            }
                        });
                    }
                }.start();

            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Got all favorite teams");

                FavoriteListFragment favoriteListFragment = FavoriteListFragment.newInstance(favoriteTeams);
                fragmentManager.beginTransaction()
                        .replace(containerFragmentId, favoriteListFragment, FAVORITE_LIST_FRAGMENT).commit();

                //https://stackoverflow.com/questions/17379002/java-lang-runtimeexception-cant-create-handler-inside-thread-that-has-not-call
                new Thread()
                {
                    public void run()
                    {
                        MainActivity.this.runOnUiThread(new Runnable()
                        {
                            public void run()
                            {
                                //Do your UI operations like dialog opening or Toast here
                                progressDialog.cancel();
                                progressDialogIsShowing[0] =false;
                            }
                        });
                    }
                }.start();

            }
        });
    }


    public void setTeamsBadges() {
        for(EventsItem event: eventsList.getEvents()){
            for(TeamsItem team : teamsList.getTeams()) {
                if (event.getStrHomeTeam().equals(team.getStrTeam())){
                    event.setHomeBadge(team.getStrTeamBadge());
                }
                if(event.getStrAwayTeam().equals(team.getStrTeam())){
                    event.setAwayBadge(team.getStrTeamBadge());
                }
            }
        }
    }

    public void showDialog(String type, String message) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        switch (type){
            case "error":
                alertDialogBuilder.setTitle(getResources().getString(R.string.error_title));
                alertDialogBuilder.setMessage(message);
                alertDialogBuilder.setPositiveButton(getResources()
                        .getString(R.string.dismiss_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                break;
            case "info":
                alertDialogBuilder.setTitle(getResources().getString(R.string.info_title));
                alertDialogBuilder.setMessage(message);
                alertDialogBuilder.setPositiveButton(getResources()
                        .getString(R.string.dismiss_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                break;
            case "subscribe":
                alertDialogBuilder.setTitle(getResources().getString(R.string.subscription_title));
                alertDialogBuilder.setMessage(message);
                alertDialogBuilder.setPositiveButton(getResources()
                        .getString(R.string.yes_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.saveSubscription(getResources().getString(R.string.subscription_key));
                    }
                });
                alertDialogBuilder.setNegativeButton(getResources()
                        .getString(R.string.no_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                break;
        }


        AlertDialog errorDialog = alertDialogBuilder.create();
        errorDialog.show();
    }
}
