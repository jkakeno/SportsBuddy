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
import com.junkakeno.sportsbuddy.Model.SportsItem;
import com.junkakeno.sportsbuddy.R;

import java.util.ArrayList;
import java.util.List;


public class SportFragment extends Fragment {

    private static final String TAG = SportFragment.class.getSimpleName();
    private static final String ARG = "sports";

    private ArrayList<SportsItem> sports;
    SportAdapter adapter;
    InteractionListener listener;


    public SportFragment() {
        // Required empty public constructor
    }

    public static SportFragment newInstance(ArrayList<SportsItem> sports) {
        SportFragment fragment = new SportFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG, sports);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        if (getArguments() != null) {
            sports = getArguments().getParcelableArrayList(ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.sport_fragment,container,false);
        RecyclerView recyclerView = view.findViewById(R.id.sports_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        adapter = new SportAdapter(getActivity(),sports, listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

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
