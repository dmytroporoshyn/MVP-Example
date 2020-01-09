package com.dmytroporoshyn.mvpexample.presenter.base;

import androidx.appcompat.app.AppCompatActivity;

public interface BasePresenter<T extends AppCompatActivity> {

    void setView(T t);

    void unbindView();
}
