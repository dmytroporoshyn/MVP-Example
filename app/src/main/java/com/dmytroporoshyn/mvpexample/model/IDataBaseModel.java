package com.dmytroporoshyn.mvpexample.model;

import io.reactivex.Observable;

public interface IDataBaseModel {

    Observable<String> getData();
}
