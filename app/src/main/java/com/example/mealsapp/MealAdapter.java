package com.example.mealsapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MealAdapter extends RecyclerView.Adapter<FilterMealPrototype> {


    private ArrayList<CategoryFilters> categoriesfilters;
    public void setMeals(ArrayList<CategoryFilters> meals){
        this.categoriesfilters=meals;


    }
    public MealAdapter(ArrayList<CategoryFilters> meals){

        try {
            this.categoriesfilters=meals;
            Log.d("debugg", String.valueOf(meals.size()));
        }catch (Exception e){
            Log.d("debugg","error:"+e.getMessage());
        }


    }
    @NonNull
    @Override
    public FilterMealPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_meal_filter, parent, false);
        return new FilterMealPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterMealPrototype prototype, int position) {
        prototype.bindTo(categoriesfilters.get(position));

    }

    @Override
    public int getItemCount() {
        return categoriesfilters.size();
    }
}
