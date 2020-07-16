package com.mvvm_android_databinding_sample.adapter;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvm_android_databinding_sample.BR;
import com.mvvm_android_databinding_sample.R;
import com.mvvm_android_databinding_sample.databinding.ItemListCityBinding;
import com.mvvm_android_databinding_sample.model.CityModel;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private List<CityModel> dataModelList;
    private Context context;

    public CityAdapter(List<CityModel> dataModelList, Context ctx) {
        this.dataModelList = dataModelList;
        context = ctx;
    }

    @Override
    public CityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        ItemListCityBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_list_city, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CityModel dataModel = dataModelList.get(position);
        holder.bind(dataModel);
        //holder.itemRowBinding.setItemClickListener(this);
    }


    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemListCityBinding itemRowBinding;

        public ViewHolder(ItemListCityBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.city, obj);
            itemRowBinding.executePendingBindings();
        }
    }


}