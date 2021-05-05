package com.example.androidtechnicaltest.dagger.component;

import com.example.androidtechnicaltest.dagger.module.ApiClientModule;
import com.example.androidtechnicaltest.dagger.module.AppModule;
import com.example.androidtechnicaltest.repository.MovieRepository;
import com.example.androidtechnicaltest.view.activity.MovieActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiClientModule.class, AppModule.class})
public interface ApiComponent {
    void inject(MovieActivity movieActivity);
    void injectMovie(MovieRepository movieRepository);
}
