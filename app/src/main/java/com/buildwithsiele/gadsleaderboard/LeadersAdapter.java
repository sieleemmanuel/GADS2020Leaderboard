package com.buildwithsiele.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class LeadersAdapter extends RecyclerView.Adapter<LeadersAdapter.mViewHolder>{
    ArrayList<LeadersByHours> mLeadersByHours;
    Context mContext;

    public LeadersAdapter(ArrayList<LeadersByHours> leadersByHours, Context context) {
        mLeadersByHours = leadersByHours;
        mContext = context;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.learner_list,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

        String learnerName = mLeadersByHours.get(position).getName();
        String learnerHours = mLeadersByHours.get(position).getHours().toString() + " learning hours, ";
        String learnerCountry = mLeadersByHours.get(position).getCountry();
        holder.txtName.setText(learnerName);
        holder.txtHoursCountry.setText(String.format("%s%s", learnerHours, learnerCountry));
        holder.mImageView.setImageResource(R.drawable.top_learner);

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView txtName;
        TextView txtHoursCountry;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageViewBadge);
            txtName = itemView.findViewById(R.id.tvName);
            txtHoursCountry = itemView.findViewById(R.id.tvHoursCountry);
        }
    }
}
