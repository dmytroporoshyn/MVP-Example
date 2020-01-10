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

import android.app.Application;

import com.dmytroporoshyn.mvpexample.di.ApplicationComponent;
import com.dmytroporoshyn.mvpexample.di.DaggerApplicationComponent;

/**
 * Override Application class.
 * Also, need to add :name parameter into manifest
 */
public class MyApplication extends Application {

    /**
     * Reference to the application graph that is used across the whole app
     * AppComponent lives in the Application class to share its lifecycle
     */
    public ApplicationComponent appComponent = DaggerApplicationComponent.create();
}
