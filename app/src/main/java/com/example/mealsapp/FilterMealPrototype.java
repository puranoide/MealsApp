package com.example.mealsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class FilterMealPrototype extends RecyclerView.ViewHolder {


    private ImageView ivMeal;
    private TextView tvMeal;
    private void initViews(){
        ivMeal=itemView.findViewById(R.id.ivmeal);
        tvMeal=itemView.findViewById(R.id.tvmeal);
    }

    public FilterMealPrototype(@NonNull View itemView) {
        super(itemView);
        initViews();
    }

    public void bindTo(CategoryFilters categoryFilters) {
        tvMeal.setText(categoryFilters.getStrMeal());
        Glide.with(itemView.getContext()).load(categoryFilters.getStrMealThumb()).into(ivMeal);
    }
}
