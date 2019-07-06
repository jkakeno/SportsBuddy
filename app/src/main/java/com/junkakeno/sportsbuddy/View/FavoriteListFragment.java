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
import android.widget.TextView;

import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.TeamsItem;
import com.junkakeno.sportsbuddy.R;

import java.util.ArrayList;

public class FavoriteListFragment extends Fragment {
    private static final String TAG = FavoriteListFragment.class.getSimpleName();
    private static final String ARG = "teams";

    ArrayList<TeamsItem> teams;
    FavoriteTeamAdapter adapter;
    InteractionListener listener;

    public FavoriteListFragment() {
        // Required empty public constructor
    }


    public static FavoriteListFragment newInstance(ArrayList<TeamsItem> teams) {
        FavoriteListFragment fragment = new FavoriteListFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG, teams);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            teams = getArguments().getParcelableArrayList(ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_list_fragment, container, false);
        TextView no_favorites = view.findViewById(R.id.no_favorites);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.favorites_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        if(!teams.isEmpty()) {
            no_favorites.setVisibility(View.INVISIBLE);
            adapter = new FavoriteTeamAdapter(getActivity(), teams, listener);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }else{
            no_favorites.setVisibility(View.VISIBLE);
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
        if(!teams.isEmpty()) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"onDetach");
        listener=null;
    }

}
