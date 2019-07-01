package com.junkakeno.sportsbuddy.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.junkakeno.sportsbuddy.Model.EventsItem;
import com.junkakeno.sportsbuddy.R;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private static final String TAG = EventListAdapter.class.getSimpleName();

    List<EventsItem> events;
    Context context;

    public EventListAdapter(Context context, List<EventsItem> events) {
        this.events = events;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final EventsItem eventsItem = events.get(position);

        String homeTeam = eventsItem.getStrHomeTeam();
        String awayTeam = eventsItem.getStrAwayTeam();
        String homeScore = eventsItem.getIntHomeScore();
        String awayScore = eventsItem.getIntAwayScore();
        String dateEvent = eventsItem.getDateEvent();

        holder.home_team.setText(homeTeam);
        holder.away_team.setText(awayTeam);
        holder.home_score.setText(homeScore);
        holder.away_score.setText(awayScore);
        holder.date_event.setText(dateEvent);

    }

    @Override
    public int getItemCount() {
        if(events !=null) {
            return events.size();
        }else{
            return 1;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView home_team;
        TextView away_team;
        TextView home_score;
        TextView away_score;
        TextView date_event;


        public ViewHolder(View itemView) {
            super(itemView);

            home_team =itemView.findViewById(R.id.home_team);
            away_team =itemView.findViewById(R.id.away_team);
            home_score =itemView.findViewById(R.id.home_score);
            away_score =itemView.findViewById(R.id.away_score);
            date_event =itemView.findViewById(R.id.date_event);

        }
    }
}
