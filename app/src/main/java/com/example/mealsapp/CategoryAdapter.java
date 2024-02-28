package com.example.mealsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryPrototype> {

    private ArrayList<Category> categories;

    public void setCategories(ArrayList<Category> categories){this.categories=categories;}
    public CategoryAdapter(ArrayList<Category> categories){this.categories=categories;}




    @NonNull
    @Override
    public CategoryPrototype onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prototype_category, parent, false);
        return new CategoryPrototype(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryPrototype prototype, int position) {
        prototype.bindTo(categories.get(position));

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
