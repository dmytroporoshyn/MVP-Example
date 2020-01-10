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

package com.dmytroporoshyn.mvpexample.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dmytroporoshyn.mvpexample.MyApplication;
import com.dmytroporoshyn.mvpexample.R;
import com.dmytroporoshyn.mvpexample.presenter.MainActivityPresenter;
import com.dmytroporoshyn.mvpexample.view.adapter.MyAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Main activity presenter.
     * You want Dagger to provide an instance of MainActivityPresenter from the graph
     */
    @Inject
    MainActivityPresenter mainActivityPresenter;

    /**
     * The Recycler view fot draw list with data.
     */
    @BindView(R.id.dataList)
    RecyclerView recyclerView;

    /**
     * The Progress bar to inform user about data loading
     */
    @BindView(R.id.loading)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Make Dagger instantiate @Inject fields in MainActivity
        ((MyApplication) getApplicationContext()).appComponent.inject(this);
        // Now mainActivityPresenter is available

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set view for ButterKnife binding
        ButterKnife.bind(this);

        //Set activity for presenter
        mainActivityPresenter.setView(this);

        //Set LayoutManager for recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Gets data.
     * Called when click on Get Data button
     *
     * "@OnClick({R.id.getData})" tels to ButterKnife create onClick method for view
     */
    @OnClick({R.id.getData})
    public void getData() {
        //Show progressBar
        progressBar.setVisibility(View.VISIBLE);
        //Call getData method
        mainActivityPresenter.getData();
    }

    /**
     * Sets data list.
     * Called from mainActivityPresenter
     *
     * @param dataList the list of retrieved data
     */
    public void setDataList(List<String> dataList) {
        //Hide progressBar
        progressBar.setVisibility(View.GONE);
        //Create new adapter for RecyclerView
        RecyclerView.Adapter adapter = new MyAdapter(dataList);
        //Set adapter to recyclerView
        recyclerView.setAdapter(adapter);
    }

    /**
     * Data get error.
     * Called from mainActivityPresenter
     */
    public void dataGetError() {
        //Show Toast
        Toast.makeText(this, R.string.error_text, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        //Call unbindView method
        mainActivityPresenter.unbindView();
        super.onDestroy();
    }
}
