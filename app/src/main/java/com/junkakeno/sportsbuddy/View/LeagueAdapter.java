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
import com.junkakeno.sportsbuddy.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.ViewHolder> {

    Context context;
    Countries leagues;
    InteractionListener listener;

    public LeagueAdapter(Context context, Countries leagues, InteractionListener listener) {
        this.context = context;
        this.leagues = leagues;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.league_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final CountrysItem league = leagues.getCountrys().get(position);
        holder.leagueName.setText(league.getStrLeague());
        final String badge = league.getStrBadge();
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
                listener.onLeagueSelectInteraction(league);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(leagues !=null) {
            return leagues.getCountrys().size();
        }else{
            return 1;
        }
    }



public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView leagueName;
    private ImageView arrow;
    private ImageView icon;
    View view;

    public ViewHolder(View itemView) {
        super(itemView);
        leagueName = (TextView) itemView.findViewById(R.id.list_item_league_name);
        arrow = (ImageView) itemView.findViewById(R.id.list_item_league_arrow);
        icon = (ImageView) itemView.findViewById(R.id.list_item_league_icon);
        view = (View) itemView.findViewById(R.id.list_item_league);

    }
}



}