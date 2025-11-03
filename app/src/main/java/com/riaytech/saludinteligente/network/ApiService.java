package com.riaytech.saludinteligente.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("posts/1")
    Call<Object> getTest();

    @POST("posts")
    Call<Object> postTest(@Body Object body);
}
