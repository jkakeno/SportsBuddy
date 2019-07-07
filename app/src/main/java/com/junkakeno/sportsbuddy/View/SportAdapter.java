package com.junkakeno.sportsbuddy.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.junkakeno.sportsbuddy.InteractionListener;
import com.junkakeno.sportsbuddy.Model.SportsItem;
import com.junkakeno.sportsbuddy.R;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {

    private static final String TAG = SportAdapter.class.getSimpleName();
    ArrayList<SportsItem> sports;
    InteractionListener listener;
    Context context;
    int row_index;

    public SportAdapter(Context context, ArrayList<SportsItem> sports, InteractionListener listener) {
        this.sports = sports;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sport_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final String title = sports.get(position).getStrSport();

        switch (title){
            case "Soccer":
                holder.navigationButtonIcon.setImageResource(R.drawable.soccer);
                break;
            case "Baseball":
                holder.navigationButtonIcon.setImageResource(R.drawable.baseball);
                break;
            case "Basketball":
                holder.navigationButtonIcon.setImageResource(R.drawable.basketball);
                break;
            case "American Football":
                holder.navigationButtonIcon.setImageResource(R.drawable.football);
                break;
            case "Ice Hockey":
                holder.navigationButtonIcon.setImageResource(R.drawable.ice_hockey);
                break;
            case "Volleyball":
                holder.navigationButtonIcon.setImageResource(R.drawable.volleyball);
                break;
        }

        holder.navigationButtonIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSportSelectInteraction(title);
                row_index = position;
                notifyDataSetChanged();
            }
        });

        if(row_index==position){
            holder.navigationButton.setBackgroundColor(context.getResources().getColor(R.color.colorLightGray));
        }
        else
        {
            holder.navigationButton.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }
    }

    @Override
    public int getItemCount() {
        if(sports !=null) {
            return sports.size();
        }else{
            return 1;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView navigationButtonIcon;
        View navigationButton;

        public ViewHolder(View itemView) {
            super(itemView);
            navigationButtonIcon =itemView.findViewById(R.id.sport_icon);
            navigationButton = itemView.findViewById(R.id.sport_item);
        }
    }
}
