package com.example.jsonparsingsample.repo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://api.coindesk.com/v1/";

    private static CoinDeskService INSTANCE;

    private RetrofitInstance() {

    }

    public static CoinDeskService getCoinDeskService() {
        if (INSTANCE == null)
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(getClient())
                    .build()
                    .create(CoinDeskService.class);

        return INSTANCE;
    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

}
