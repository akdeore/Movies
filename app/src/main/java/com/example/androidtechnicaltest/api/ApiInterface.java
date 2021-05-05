package com.example.androidtechnicaltest.api;

import com.example.androidtechnicaltest.model.MoviesList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    @GET("movie/popular")
    Call<MoviesList> getMovies(@QueryMap Map<String , String> queryParameters);
}
