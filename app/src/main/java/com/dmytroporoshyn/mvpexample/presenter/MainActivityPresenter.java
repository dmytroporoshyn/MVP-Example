package com.dmytroporoshyn.mvpexample.presenter;

import androidx.annotation.NonNull;

import com.dmytroporoshyn.mvpexample.DisposableManager;
import com.dmytroporoshyn.mvpexample.model.IDataBaseModel;
import com.dmytroporoshyn.mvpexample.presenter.base.BasePresenter;
import com.dmytroporoshyn.mvpexample.view.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivityPresenter implements BasePresenter<MainActivity> {

    private IDataBaseModel dataBaseModel;
    private MainActivity mainActivity;

    public MainActivityPresenter(IDataBaseModel dataBaseModel) {
        this.dataBaseModel = dataBaseModel;
    }

    @Override
    public void setView(@NonNull MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void getData() {
        List<String> stringList = new ArrayList<>();
        DisposableManager.add(dataBaseModel.getData()
                .doOnComplete(() -> mainActivity.setDataList(stringList))
                .doOnError(throwable -> {
                    throwable.printStackTrace();
                    mainActivity.dataGetError();
                })
                .subscribe(stringList::add)
        );
    }

    @Override
    public void unbindView() {
        DisposableManager.dispose();
    }
}
