package com.junkakeno.sportsbuddy.View;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.EventsItem;
import com.junkakeno.sportsbuddy.Model.Seasons;
import com.junkakeno.sportsbuddy.Model.SeasonsItem;
import com.junkakeno.sportsbuddy.Model.TeamsItem;
import com.junkakeno.sportsbuddy.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TeamDetailFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private static final String TAG = TeamDetailFragment.class.getSimpleName();
    private static final String ARG1 = "team";
    private static final String ARG2 = "events";
    private static final String ARG3 = "seasons";

    TeamsItem team;
    Events events;
    Seasons seasons;
    FloatingActionButton favorite;
    InteractionListener listener;
    TeamEventAdapter adapter;
    boolean isFavorite;
    Spinner seasonSpinner;
    ArrayAdapter<String> seasonAdapter;


    public static TeamDetailFragment newInstance(TeamsItem team, Events events, Seasons seasons) {
        TeamDetailFragment fragment = new TeamDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG1, team);
        args.putParcelable(ARG2, events);
        args.putParcelable(ARG3, seasons);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            team = getArguments().getParcelable(ARG1);
            events = getArguments().getParcelable(ARG2);
            seasons = getArguments().getParcelable(ARG3);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");

        View view = inflater.inflate(R.layout.team_detail_fragment,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.team_recycler_view);
        TextView country = view.findViewById(R.id.team_country);
        TextView league = view.findViewById(R.id.team_league);
        TextView foundedYear = view.findViewById(R.id.team_founded);
        TextView noEvent = view.findViewById(R.id.no_event_msg);
        final ImageView teamImage = view.findViewById(R.id.team_image);


        seasonSpinner = view.findViewById(R.id.season_spinner);

        seasonSpinner.setOnItemSelectedListener(this);

        country.setText(team.getStrCountry());
        league.setText(team.getStrLeague());
        foundedYear.setText(team.getIntFormedYear());
        Picasso.with(getActivity()).load(team.getStrTeamBadge()).centerInside().fit().into(teamImage);

        favorite =  view.findViewById(R.id.favorite);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());


        isFavorite = team.isFavorite();

        if(isFavorite){
            favorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        }else {
            favorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLightGray)));
        }

        ArrayList<String> seasonList = new ArrayList<>();
        seasonList.add("Select a season");
        for(SeasonsItem season:seasons.getSeasons()){
            seasonList.add(season.getStrSeason());
        }

        seasonAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, seasonList);
        seasonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seasonSpinner.setAdapter(seasonAdapter);


        if(!events.getTeamEvents().isEmpty()) {
            noEvent.setVisibility(View.INVISIBLE);
            adapter = new TeamEventAdapter(getActivity(), events, listener);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }else{
            noEvent.setVisibility(View.VISIBLE);
        }

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG,"onAttach");
        listener = (InteractionListener) context;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");

        if(!events.getTeamEvents().isEmpty()) {
            adapter.notifyDataSetChanged();
        }

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFavorite) {
                    favorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
                    listener.onFavoriteSaveInteraction(team);
                    isFavorite = true;
                }else{
                    favorite.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorLightGray)));
                    listener.onFavoriteDeleteInteraction(team);
                    isFavorite = false;
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
        listener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String season = adapterView.getItemAtPosition(position).toString();
        Log.d(TAG,"Selected season: " + season);
        if(!adapterView.getItemAtPosition(position).toString().equals("Select a season")) {
            listener.onSeasonSelectInteraction(season, team.getIdLeague(), team);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}