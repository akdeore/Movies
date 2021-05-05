package com.example.androidtechnicaltest.view.activity;

import android.app.Application;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidtechnicaltest.R;
import com.example.androidtechnicaltest.app.MyApplication;
import com.example.androidtechnicaltest.databinding.ActivityMovieListBinding;
import com.example.androidtechnicaltest.model.Movie;
import com.example.androidtechnicaltest.view.adapter.MovieAdapter;
import com.example.androidtechnicaltest.viewmodel.MovieViewModel;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MovieActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;
    @Inject
    Application application;
    private ActivityMovieListBinding binding;
    private MovieViewModel movieViewModel;
    public static ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(((MovieActivity) this).getSupportActionBar()).setTitle("Movies");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list);
        ((MyApplication) getApplication()).getComponent().inject(this);
        binding.setLifecycleOwner(this);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getMovies();

        showLoadingBar();
        observableChanges();
    }

    private void observableChanges() {
        movieViewModel.movieList.observe(this, responseMovie -> Recycler(responseMovie.getMovies()));

        movieViewModel.errorMessage.observe(this, s -> Toast.makeText(MovieActivity.this, s, Toast.LENGTH_LONG).show());
    }

    private void showLoadingBar() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void Recycler(List<Movie> movies) {
        binding.setAdapter(new MovieAdapter(movies, MovieActivity.this));
    }
}
