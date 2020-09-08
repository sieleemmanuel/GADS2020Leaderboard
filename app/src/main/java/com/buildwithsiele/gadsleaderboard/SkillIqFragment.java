package com.buildwithsiele.gadsleaderboard;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIqFragment extends Fragment {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private ArrayList<LeadersBySkillIQ> mLeadersBySkillIQS = new ArrayList<>();
    private ProgressBar mProgressBar;


    public SkillIqFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_iq, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      mRecyclerView = view.findViewById(R.id.rvSkillIq);
      mProgressBar = view.findViewById(R.id.loadingScores);
      this.mContext = getContext();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        getLeanerScores();
    }

    private void getLeanerScores() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LeadersBySkillIQ>> call = apiService.getLeadersBySkillIQ();
        mProgressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<List<LeadersBySkillIQ>>() {
            @Override
            public void onResponse(@NonNull Call<List<LeadersBySkillIQ>> call,
                                   @NonNull Response<List<LeadersBySkillIQ>> response) {
                if (response.isSuccessful()) {
                    mProgressBar.setVisibility(View.GONE);
                    mLeadersBySkillIQS = (ArrayList<LeadersBySkillIQ>) response.body();
                    SkillIqAdapter skillIqAdapter = new SkillIqAdapter(mContext, mLeadersBySkillIQS);
                    mRecyclerView.setAdapter(skillIqAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LeadersBySkillIQ>> call, @NonNull Throwable t) {

            }
        });
    }
}