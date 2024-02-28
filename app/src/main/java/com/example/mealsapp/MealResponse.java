package com.example.mealsapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MealResponse {
    //aca se tiene que poner el nombre que se recible en la api
    @SerializedName("meals")
    private ArrayList<CategoryFilters> categories;

    public ArrayList<CategoryFilters> getCategories() {
        return categories;
    }
}
