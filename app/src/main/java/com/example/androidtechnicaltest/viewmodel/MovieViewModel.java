package com.example.androidtechnicaltest.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.androidtechnicaltest.model.MoviesList;
import com.example.androidtechnicaltest.repository.MovieRepository;
import com.example.androidtechnicaltest.util.Constants;
import com.example.androidtechnicaltest.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class MovieViewModel extends AndroidViewModel {
    public MutableLiveData<MoviesList> movieList = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private final MovieRepository movieRepository = new MovieRepository();

    public MovieViewModel(@NonNull Application application) {
        super(application);
    }

    public void getMovies() {
        boolean isConnected = Utils.isNetworkAvailable(getApplication());
        if (isConnected) {
            Map<String, String> map = new HashMap<>();
            map.put(Constants.TOKEN_NAME, Constants.TOKEN_VALUE);
            movieList = movieRepository.getMovies(map);
        } else {
            errorMessage.setValue("No internet Connection");
        }
    }
}
