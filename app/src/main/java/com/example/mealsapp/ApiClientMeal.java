package com.example.mealsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientMeal {
    private static final String BASE_URL_MEAL = "https://www.themealdb.com/api/json/v1/1/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_MEAL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
