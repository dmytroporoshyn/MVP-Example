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

package com.dmytroporoshyn.mvpexample.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmytroporoshyn.mvpexample.R;
import com.dmytroporoshyn.mvpexample.view.viewHolder.MyViewHolder;

import java.util.List;

/**
 * The type My adapter.
 *
 * Adapter class must be extends RecyclerView.Adapter<MyViewHolder>
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    /**
     * List with data
     */
    private List<String> dataList;

    /**
     * Instantiates a new My adapter.
     *
     * @param dataList the list with data
     */
    public MyAdapter(@NonNull List<String> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Create view from our layout
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //Call bind method from our MyViewHolder
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        //set size
        return dataList.size();
    }
}
