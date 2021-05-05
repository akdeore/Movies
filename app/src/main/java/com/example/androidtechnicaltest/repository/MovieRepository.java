package com.example.androidtechnicaltest.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.androidtechnicaltest.api.ApiInterface;
import com.example.androidtechnicaltest.app.MyApplication;
import com.example.androidtechnicaltest.model.MoviesList;

import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.androidtechnicaltest.view.activity.MovieActivity.progressDialog;

public class MovieRepository {
    @Inject
    Retrofit retrofit;
    @Inject
    Application application;
    private final ApiInterface apiInterface ;

    public MovieRepository(){
        MyApplication.getComponent().injectMovie(this);
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public MutableLiveData<MoviesList> getMovies(Map<String , String> stringMap){
        MutableLiveData<MoviesList> MoviesListMutableLiveData = new MutableLiveData<>();
        apiInterface.getMovies(stringMap).enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                progressDialog.dismiss();
                if (response.isSuccessful()){
                    MoviesListMutableLiveData.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                progressDialog.dismiss();
                MoviesListMutableLiveData.setValue(null);
            }
        });
        return MoviesListMutableLiveData;
    }
}
