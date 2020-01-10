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
