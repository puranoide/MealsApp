package com.example.mealsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientCategory {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/categories.php/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }

}
