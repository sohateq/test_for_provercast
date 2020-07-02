package com.akameko.testforprovercast.repository;

import com.akameko.testforprovercast.repository.pogos.GoogleSearch;
import com.akameko.testforprovercast.repository.pogos.Item;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private Retrofit retrofit;
    private Api api;

    public Repository() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }




    public Single<GoogleSearch> getResults(String request) {
        return api.getResults(request);
    }

//public Single<GoogleSearch> getResults(String request) {
//    return api.getResults();
//}
}
