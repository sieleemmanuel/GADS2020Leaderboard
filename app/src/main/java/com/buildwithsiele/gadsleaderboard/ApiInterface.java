package com.buildwithsiele.gadsleaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface ApiInterface {
    @GET("/api/hours?_sort=hours&_order=desc")
    Call<List<LeadersByHours>> getLeadersByHours();
    @GET("/api/skilliq?_sort=score&_order=desc")
    Call<List<LeadersBySkillIQ>> getLeadersBySkillIQ();

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<Void>  sendResponse(
            @Field("entry.1877115667")String firstName,
            @Field("entry.2006916086")String lastName,
            @Field("entry.1824927963")String emailAddress,
            @Field("entry.284483984")String linkToProject
    );

}
