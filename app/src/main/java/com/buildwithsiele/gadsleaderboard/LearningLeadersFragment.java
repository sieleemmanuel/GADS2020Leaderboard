package com.buildwithsiele.gadsleaderboard;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment {
    private Context mContext;
    private RecyclerView mRecyclerView;
    private ArrayList<LeadersByHours> mLeadersByHours = new ArrayList<>();
    LeadersAdapter mLeadersAdapter;
    private ProgressBar mProgressBar;

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    public static LearningLeadersFragment newInstance(String param1, String param2) {
        return new LearningLeadersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mContext = getContext();
        mRecyclerView= view.findViewById(R.id.rvLearders);
        mProgressBar = view.findViewById(R.id.loadingLearners);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
        getLearners();




    }

    private void getLearners() {
        mProgressBar.setVisibility(View.VISIBLE);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<LeadersByHours>> call = apiService.getLeadersByHours();
        call.enqueue(new Callback<List<LeadersByHours>>() {

                         @Override
                         public void onResponse( @NonNull Call<List<LeadersByHours>> call,
                                                 @NonNull Response<List<LeadersByHours>> response) {
                            if (response.isSuccessful()) {
                                mProgressBar.setVisibility(View.GONE);
                                mLeadersByHours = (ArrayList<LeadersByHours>) response.body();
                                mLeadersAdapter = new LeadersAdapter(mLeadersByHours, mContext);
                                mRecyclerView.setAdapter(mLeadersAdapter);
                            }
                         }

                         @Override
                         public void onFailure(@NonNull Call<List<LeadersByHours>> call, @NonNull Throwable t) {
                             Log.d("TAG","Response = "+t.toString());
                         }
                     }
        );
    }
}