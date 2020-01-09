package com.dmytroporoshyn.mvpexample.di;

import com.dmytroporoshyn.mvpexample.model.DataBaseModel;
import com.dmytroporoshyn.mvpexample.model.IDataBaseModel;
import com.dmytroporoshyn.mvpexample.presenter.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
class MainModule {

    @Provides
    IDataBaseModel dataBaseModel() {
        return new DataBaseModel();
    }

    @Provides
    MainActivityPresenter mainActivityPresenter() {
        return new MainActivityPresenter(dataBaseModel());
    }
}
