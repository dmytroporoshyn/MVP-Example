package com.dmytroporoshyn.mvpexample.model;

import io.reactivex.Observable;

public class DataBaseModel implements IDataBaseModel {

    @Override
    public Observable<String> getData() {
        return Observable.create(emitter -> {
            try {
                for (int i = 0; i < 5; i++) {
                    emitter.onNext(String.valueOf(i));
                }
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }
}
