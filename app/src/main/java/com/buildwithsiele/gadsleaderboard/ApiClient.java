package com.buildwithsiele.gadsleaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {
    public static String BASE_URL = "https://gadsapi.herokuapp.com";
    public static String FORM_RESPOSE_BASE_URL = "https://docs.google.com/forms/d/e/";

    private static Retrofit sRetrofit;
    public static  Retrofit getClient(){
        if (sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
    public static  Retrofit sendResponse(){
        if (sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(FORM_RESPOSE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
