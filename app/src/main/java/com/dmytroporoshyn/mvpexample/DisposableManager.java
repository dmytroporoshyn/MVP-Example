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

package com.dmytroporoshyn.mvpexample;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * The type Disposable manager.
 */
public class DisposableManager {

    /**
     * The composite disposable.
     */
    private static CompositeDisposable compositeDisposable;

    /**
     * Add disposable to compositeDisposable
     *
     * @param disposable the disposable
     */
    public static void add(Disposable disposable) {
        getCompositeDisposable().add(disposable);
    }

    /**
     * Dispose compositeDisposable
     */
    public static void dispose() {
        getCompositeDisposable().dispose();
    }

    /**
     * Get composite disposable
     *
     * @return the composite disposable
     */
    private static CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }
}
