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

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityPresenter mainActivityPresenter;

    @BindView(R.id.dataList)
    RecyclerView recyclerView;

    @BindView(R.id.loading)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplicationContext()).appComponent.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainActivityPresenter.setView(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick({R.id.getData})
    public void getData() {
        progressBar.setVisibility(View.VISIBLE);
        mainActivityPresenter.getData();
    }

    public void setDataList(List<String> dataList) {
        progressBar.setVisibility(View.GONE);

        RecyclerView.Adapter adapter = new MyAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    public void dataGetError() {
        Toast.makeText(this, R.string.error_text, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        mainActivityPresenter.unbindView();
        super.onDestroy();
    }
}
