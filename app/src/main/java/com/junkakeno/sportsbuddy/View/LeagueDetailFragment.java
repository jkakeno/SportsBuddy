package com.junkakeno.sportsbuddy.View;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.EventsItem;
import com.junkakeno.sportsbuddy.Model.Teams;
import com.junkakeno.sportsbuddy.Model.TeamsItem;
import com.junkakeno.sportsbuddy.R;

import java.util.ArrayList;

public class LeagueDetailFragment extends Fragment {
    private static final String TAG = LeagueDetailFragment.class.getSimpleName();
    private static final String ARG1 = "teams";
    private static final String ARG2 = "events";

    Teams teams;
    Events events;
    InteractionListener listener;

    public LeagueDetailFragment() {
        // Required empty public constructor
    }


    public static LeagueDetailFragment newInstance(Teams teams, Events events) {
        LeagueDetailFragment fragment = new LeagueDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG1, teams);
        args.putParcelable(ARG2, events);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            teams = getArguments().getParcelable(ARG1);
            events = getArguments().getParcelable(ARG2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.league_detail_fragment,container,false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(teams.getTeams().get(0).getStrLeague());
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onBackInteraction(TAG);
            }
        });

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(LeagueTeamListFragment.newInstance(teams),getResources().getString(R.string.team_tab_title));
        sectionsPagerAdapter.addFragment(LeagueEventListFragment.newInstance(events),getResources().getString(R.string.matches_tab_title));

        ViewPager viewPager = view.findViewById(R.id.viewpager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

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
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
        listener = null;
    }



}
