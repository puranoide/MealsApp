package com.example.mealsapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryResponse {

    @SerializedName("categories")
    private ArrayList<Category> categories;

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
