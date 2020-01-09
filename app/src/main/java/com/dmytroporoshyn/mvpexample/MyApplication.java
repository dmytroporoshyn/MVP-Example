package com.dmytroporoshyn.mvpexample;

import android.app.Application;

import com.dmytroporoshyn.mvpexample.di.ApplicationComponent;
import com.dmytroporoshyn.mvpexample.di.DaggerApplicationComponent;

public class MyApplication extends Application {

    // Reference to the application graph that is used across the whole app
    public ApplicationComponent appComponent = DaggerApplicationComponent.create();
}
