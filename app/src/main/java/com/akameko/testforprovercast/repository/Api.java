package com.akameko.testforprovercast.repository;

import com.akameko.testforprovercast.repository.pojos.GoogleSearch;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("customsearch/v1?key=AIzaSyD9pfWRmd-B2EFKpILTde6Hn5U80LnVlAQ&cx=018045346402552271755:_r8dr45irnc")
    Single<GoogleSearch> getResults(@Query("q") String request);


}
