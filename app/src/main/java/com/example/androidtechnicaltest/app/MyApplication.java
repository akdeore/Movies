package com.example.androidtechnicaltest.app;

import android.app.Application;

import com.example.androidtechnicaltest.dagger.component.ApiComponent;
import com.example.androidtechnicaltest.dagger.component.DaggerApiComponent;
import com.example.androidtechnicaltest.dagger.module.ApiClientModule;
import com.example.androidtechnicaltest.dagger.module.AppModule;
import com.example.androidtechnicaltest.util.Constants;

public class MyApplication extends Application {

    public static ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiClientModule(new ApiClientModule(Constants.BASE_URL))
                .build();
    }

    public static ApiComponent getComponent() {
        return mApiComponent;
    }
}
