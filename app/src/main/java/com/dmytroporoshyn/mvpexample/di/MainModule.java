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

package com.dmytroporoshyn.mvpexample.di;

import com.dmytroporoshyn.mvpexample.model.DataBaseModel;
import com.dmytroporoshyn.mvpexample.model.IDataBaseModel;
import com.dmytroporoshyn.mvpexample.presenter.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * The type Main module.
 * "@Module" informs Dagger that this class is a Dagger Module
 */
@Module
class MainModule {

    /* @Provides tell Dagger how to create instances of the type that this function
     * returns (i.e. DataBaseModel).
     * Function parameters are the dependencies of this type.
     */

    /**
     * Function that create IDataBaseModel object
     *
     * @return the DataBaseModel
     */
    @Provides
    IDataBaseModel dataBaseModel() {
        /* Whenever Dagger needs to provide an instance of type DataBaseModel,
         * this code (the one inside the @Provides method) is run.
         */
        return new DataBaseModel();
    }

    /**
     * Function that create MainActivityPresenter object
     *
     * @return the MainActivityPresenter
     */
    @Provides
    MainActivityPresenter mainActivityPresenter() {
        return new MainActivityPresenter(dataBaseModel());
    }
}
