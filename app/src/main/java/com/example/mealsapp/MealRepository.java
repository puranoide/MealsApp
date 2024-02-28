package com.example.mealsapp;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MealRepository {
    private ShowMealsInterface showMealsInterface;
    public void setShowMealsInterface(ShowMealsInterface showMealsInterface) {
        this.showMealsInterface = showMealsInterface;
    }


    public void searchMeals(String mealName) {
        Log.d("debugg",mealName);
        Retrofit retrofit = ApiClientMeal.getRetrofit();
        MealService mealService = retrofit.create(MealService.class);
        Call<MealResponse> searchMeal = mealService.getMealsByCategory(mealName);

        searchMeal.enqueue(new Callback<MealResponse>() {

            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                Log.d("debugg",response.isSuccessful()+"");
                if (response.isSuccessful()){
                    MealResponse mealResponse = response.body();
                    showMealsInterface.showMeals(Objects.requireNonNull(mealResponse).getCategories());
                }
            }

            @Override
            public void onFailure(@NonNull Call<MealResponse> call, @NonNull Throwable t) {
                Log.d("MealRepository", t.toString());
            }
        });
    }


    public interface ShowMealsInterface {
        void showMeals(ArrayList<CategoryFilters> categoryFilters);
    }
}
