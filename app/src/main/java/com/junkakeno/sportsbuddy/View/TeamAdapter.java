package com.junkakeno.sportsbuddy.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.Countries;
import com.junkakeno.sportsbuddy.Model.CountrysItem;
import com.junkakeno.sportsbuddy.Model.Teams;
import com.junkakeno.sportsbuddy.Model.TeamsItem;
import com.junkakeno.sportsbuddy.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    Context context;
    Teams teams;
    InteractionListener listener;
    int row_index;

    public TeamAdapter(Context context, Teams teams, InteractionListener listener) {
        this.context = context;
        this.teams = teams;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final TeamsItem team = teams.getTeams().get(position);
        holder.teamName.setText(team.getStrTeam());
        final String badge = team.getStrTeamBadge();
        if(badge!=null) {
            Picasso.with(context).load(badge).fetch(new Callback() {
                @Override
                public void onSuccess() {
                    Picasso.with(context).load(badge).into(holder.icon);
                }

                @Override
                public void onError() {
                    holder.icon.setImageResource(R.drawable.ic_default_icon);
                }
            });
        }else{
            holder.icon.setImageResource(R.drawable.ic_default_icon);
        }


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onTeamSelectInteraction(team);
                row_index = position;
                notifyDataSetChanged();
            }
        });

        if(row_index==position){
            holder.view.setBackgroundColor(context.getResources().getColor(R.color.colorLightGray));
        }
        else
        {
            holder.view.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }

    }

    @Override
    public int getItemCount() {
        if(teams !=null) {
            return teams.getTeams().size();
        }else{
            return 1;
        }
    }



public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView teamName;
    private ImageView arrow;
    private ImageView icon;
    View view;

    public ViewHolder(View itemView) {
        super(itemView);
        teamName = (TextView) itemView.findViewById(R.id.list_item_team_name);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_team_arrow);
        icon = (ImageView) itemView.findViewById(R.id.list_item_team_icon);
        view = (View) itemView.findViewById(R.id.list_item_team);

    }
}



}