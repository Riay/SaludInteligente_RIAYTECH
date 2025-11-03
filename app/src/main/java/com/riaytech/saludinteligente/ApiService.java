package com.riaytech.saludinteligente;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts/1")
    Call<JsonObject> testConnection();
}
