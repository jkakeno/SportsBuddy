package com.junkakeno.sportsbuddy.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.Events;
import com.junkakeno.sportsbuddy.Model.EventsItem;
import com.junkakeno.sportsbuddy.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TeamEventAdapter extends RecyclerView.Adapter<TeamEventAdapter.ViewHolder> {

    Context context;
    Events events;
    InteractionListener listener;

    public TeamEventAdapter(Context context, Events events, InteractionListener listener) {
        this.context = context;
        this.events = events;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final EventsItem eventsItem = events.getEvents().get(position);
        String eventDate = eventsItem.getDateEvent();
        String homeTeam = eventsItem.getStrHomeTeam();
        String awayTeam = eventsItem.getStrAwayTeam();
        String homeScore = eventsItem.getIntHomeScore();
        String awayScore = eventsItem.getIntAwayScore();
        final String homeBadge = eventsItem.getHomeBadge();
        final String awayBadge = eventsItem.getAwayBadge();

        holder.eventDate.setText(eventDate);
        holder.homeTeam.setText(homeTeam);
        holder.homeScore.setText(homeScore);
        holder.awayTeam.setText(awayTeam);
        holder.awayScore.setText(awayScore);

        Picasso.with(context).load(homeBadge).fetch(new Callback() {
            @Override
            public void onSuccess() {
                Picasso.with(context).load(homeBadge).into(holder.homeBadge);
            }

            @Override
            public void onError() {
//                holder.homeBadge.setImageResource(R.drawable.ic_default_icon);
            }
        });

        Picasso.with(context).load(awayBadge).fetch(new Callback() {
            @Override
            public void onSuccess() {
                Picasso.with(context).load(awayBadge).into(holder.awayBadge);
            }

            @Override
            public void onError() {
//                holder.homeBadge.setImageResource(R.drawable.ic_default_icon);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(events !=null) {
            return events.getEvents().size();
        }else{
            return 1;
        }
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView eventDate;
        private TextView homeTeam;
        private TextView homeScore;
        private TextView awayTeam;
        private TextView awayScore;
        ImageView homeBadge;
        ImageView awayBadge;
        View team;


        public ViewHolder(View itemView) {
            super(itemView);
            eventDate = (TextView) itemView.findViewById(R.id.date_event);
            homeTeam = (TextView) itemView.findViewById(R.id.home_team);
            homeScore = (TextView) itemView.findViewById(R.id.home_score);
            awayTeam = (TextView) itemView.findViewById(R.id.away_team);
            awayScore = (TextView) itemView.findViewById(R.id.away_score);
            homeBadge = (ImageView) itemView.findViewById(R.id.home_badge);
            awayBadge = (ImageView) itemView.findViewById(R.id.away_badge);
            team = itemView.findViewById(R.id.list_item_team);
        }
    }

}