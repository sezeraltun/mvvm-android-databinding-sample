package com.mvvm_android_databinding_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mvvm_android_databinding_sample.adapter.CityAdapter;
import com.mvvm_android_databinding_sample.databinding.ActivityMainBinding;
import com.mvvm_android_databinding_sample.model.CityModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setRecyclerView();

    }


    private void setRecyclerView() {
        RecyclerView recyclerView = binding.rview; // In xml we have given id rv_movie_list to RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // you can use getContext() instead of "this"
        recyclerView.setLayoutManager(layoutManager);

        List<CityModel> movieList = new ArrayList<>();
        movieList.add(new CityModel("İstanbul", 34));
        movieList.add(new CityModel("Ankara", 6));
        // ...
        CityAdapter adapter = new CityAdapter(movieList,this);
        recyclerView.setAdapter(adapter);
    }
}
