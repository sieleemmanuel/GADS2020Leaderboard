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

class SkillIqAdapter extends RecyclerView.Adapter<SkillIqAdapter.mViewHolder> {
    Context mContext;
    ArrayList<LeadersBySkillIQ> mLeadersBySkillIQS;

    public SkillIqAdapter(Context context, ArrayList<LeadersBySkillIQ> leadersBySkillIQS) {
        mContext = context;
        mLeadersBySkillIQS = leadersBySkillIQS;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.score_list,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        String learnerName = mLeadersBySkillIQS.get(position).getName();
        String learnerScore = mLeadersBySkillIQS.get(position).getScore().toString() + " Skill IQ Score, ";
        String learnerCountry = mLeadersBySkillIQS.get(position).getCountry();
        holder.txtName.setText(learnerName);
        holder.txtScoreCountry.setText(String.format("%s%s", learnerScore, learnerCountry));
        holder.mImageView.setImageResource(R.drawable.skill_iq);

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView txtName;
        TextView txtScoreCountry;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageViewBadge);
            txtName = itemView.findViewById(R.id.tvName);
            txtScoreCountry = itemView.findViewById(R.id.tvHoursCountry);
        }
    }
}
