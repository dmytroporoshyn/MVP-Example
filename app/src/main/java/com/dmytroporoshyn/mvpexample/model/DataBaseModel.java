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

package com.dmytroporoshyn.mvpexample.model;

import io.reactivex.Observable;

/**
 * The type Data base model.
 */
public class DataBaseModel implements IDataBaseModel {

    /**
     * The function for simulate work of Observable
     *
     * @return Observable<String>
     */
    @Override
    public Observable<String> getData() {
        return Observable.create(emitter -> {
            try {
                for (int i = 0; i < 5; i++) {
                    //Send value to Observable
                    emitter.onNext(String.valueOf(i));
                }
                //Notify Observable that all data send
                emitter.onComplete();
            } catch (Exception e) {
                //Notify Observable that error occurred while we retrieve data
                emitter.onError(e);
            }
        });
    }
}
