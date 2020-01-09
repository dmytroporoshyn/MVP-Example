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
