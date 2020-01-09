package com.dmytroporoshyn.mvpexample.di;

import com.dmytroporoshyn.mvpexample.view.MainActivity;

import dagger.Component;

@Component(modules = MainModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);
}
