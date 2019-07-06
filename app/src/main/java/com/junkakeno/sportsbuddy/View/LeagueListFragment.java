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
import com.junkakeno.sportsbuddy.Model.Countries;
import com.junkakeno.sportsbuddy.R;


public class LeagueListFragment extends Fragment {
    private static final String TAG = LeagueListFragment.class.getSimpleName();
    private static final String ARG = "leagues";

    Countries leagues;
    public LeagueAdapter adapter;
    InteractionListener listener;

    public LeagueListFragment() {
        // Required empty public constructor
    }

    public static LeagueListFragment newInstance(Countries leagues) {
        LeagueListFragment fragment = new LeagueListFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG, leagues);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            leagues = getArguments().getParcelable(ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.league_list_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.league_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        adapter = new LeagueAdapter(getActivity(),leagues,listener);
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
