package com.buildwithsiele.gadsleaderboard;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {
    public static String BASE_URL = "https://gadsapi.herokuapp.com";
    public static String FORM_RESPOSE_BASE_URL = "https://docs.google.com/forms/d/e/";

    private static Retrofit sRetrofit;
    public static OkHttpClient mHttpClient;
    private static HttpLoggingInterceptor sHttpLoggingInterceptor = new HttpLoggingInterceptor();

    public static Retrofit getClient() {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static  Retrofit sendResponse() {
        sHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mHttpClient = new OkHttpClient.Builder()
                .addInterceptor(sHttpLoggingInterceptor).build();
        sRetrofit = new Retrofit.Builder()
                .baseUrl(FORM_RESPOSE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mHttpClient)
                .build();

        return sRetrofit;
    }
}
