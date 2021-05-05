package com.example.androidtechnicaltest.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.androidtechnicaltest.R;
import com.example.androidtechnicaltest.databinding.ActivityMovieDetailsBinding;
import com.example.androidtechnicaltest.model.Movie;

import java.util.Objects;

public class MovieDetailsActivity extends AppCompatActivity {
    private ActivityMovieDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(((MovieDetailsActivity) this).getSupportActionBar()).setTitle("Details");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);
        Intent intent = getIntent();
        if (intent != null) {
            Movie movie = intent.getParcelableExtra("Movie");
            binding.setMovie(movie);
        }
    }
}
