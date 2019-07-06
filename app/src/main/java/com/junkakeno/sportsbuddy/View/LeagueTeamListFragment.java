package com.junkakeno.sportsbuddy.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.Teams;
import com.junkakeno.sportsbuddy.Model.TeamsItem;
import com.junkakeno.sportsbuddy.R;

import java.util.ArrayList;


public class LeagueTeamListFragment extends Fragment {
    private static final String TAG = LeagueTeamListFragment.class.getSimpleName();
    private static final String ARG = "events";

    Teams teams;
    public TeamAdapter adapter;
    InteractionListener listener;

    public LeagueTeamListFragment() {
        // Required empty public constructor
    }

    public static LeagueTeamListFragment newInstance(Teams teams) {
        LeagueTeamListFragment fragment = new LeagueTeamListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG, teams);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            teams = getArguments().getParcelable(ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_list_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.team_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        adapter = new TeamAdapter(getActivity(),teams,listener);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
        listener=null;
    }

}
