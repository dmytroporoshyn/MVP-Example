/*
 * Copyright (c) 2020.  Dmytro Poroshyn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dmytroporoshyn.mvpexample.presenter;

import androidx.annotation.NonNull;

import com.dmytroporoshyn.mvpexample.DisposableManager;
import com.dmytroporoshyn.mvpexample.model.IDataBaseModel;
import com.dmytroporoshyn.mvpexample.presenter.base.BasePresenter;
import com.dmytroporoshyn.mvpexample.view.MainActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Main activity presenter.
 */
public class MainActivityPresenter implements BasePresenter<MainActivity> {

    /**
     * The dataBaseModel interface for retrieve data
     */
    private IDataBaseModel dataBaseModel;
    /**
     * The mainActivity for notify activity
     */
    private MainActivity mainActivity;

    /**
     * Instantiates a new Main activity presenter.
     *
     * @param dataBaseModel the data base model
     */
    public MainActivityPresenter(IDataBaseModel dataBaseModel) {
        this.dataBaseModel = dataBaseModel;
    }

    @Override
    public void setView(@NonNull MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    /**
     * Gets data.
     */
    public void getData() {
        List<String> stringList = new ArrayList<>();
        //add to DisposableManager new disposable
        DisposableManager.add(
                //call getData function
                dataBaseModel.getData()
                //add OnComplete function to notify Main Activity
                .doOnComplete(() -> mainActivity.setDataList(stringList))
                //add OnError function to notify Main Activity about error
                .doOnError(throwable -> {
                    throwable.printStackTrace();
                    mainActivity.dataGetError();
                })
                //subscribe on observable
                .subscribe(stringList::add)
        );
    }

    @Override
    public void unbindView() {
        //dispose when called unbindView
        DisposableManager.dispose();
    }
}
