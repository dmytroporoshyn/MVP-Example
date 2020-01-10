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

import com.dmytroporoshyn.mvpexample.view.MainActivity;

import dagger.Component;

/**
 * The interface Application component.
 *
 * Definition of the Application graph
 */
@Component(modules = MainModule.class)
public interface ApplicationComponent {

    /**
     * Inject.
     * This tells Dagger that MainActivity requests injection so the graph needs to
     * satisfy all the dependencies of the fields that MainActivity is injecting.
     *
     * @param mainActivity the main activity
     */
    void inject(MainActivity mainActivity);
}
