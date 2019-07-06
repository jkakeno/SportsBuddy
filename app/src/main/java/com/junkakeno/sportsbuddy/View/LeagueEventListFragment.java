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
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.junkakeno.sportsbuddy.Controller.MainActivity;
import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.EventsItem;
import com.junkakeno.sportsbuddy.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LeagueEventListFragment extends Fragment {
    private static final String TAG = LeagueEventListFragment.class.getSimpleName();
    private static final String ARG = "events";

    Events events;
    public EventAdapter adapter;
    InteractionListener listener;


    public LeagueEventListFragment() {
        // Required empty public constructor
    }

    public static LeagueEventListFragment newInstance(Events events) {
        LeagueEventListFragment fragment = new LeagueEventListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG, events);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            events = getArguments().getParcelable(ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_list_fragment, container, false);





        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.match_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        adapter = new EventAdapter(getActivity(),events,listener);
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
