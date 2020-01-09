package com.dmytroporoshyn.mvpexample.view.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmytroporoshyn.mvpexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.textContent)
    TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(String text) {
        textView.setText(text);
    }
}
