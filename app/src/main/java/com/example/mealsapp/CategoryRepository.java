package com.example.mealsapp;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryRepository {

    private ShowCategoryInterface showCategoryInterface;

    public void setShowCategoryInterface(ShowCategoryInterface showCategoryInterface){
    this.showCategoryInterface=showCategoryInterface;
    }

    public void getCategories() {

        Retrofit retrofit = ApiClientCategory.getRetrofit();
        CategoryService categoryService = retrofit.create(CategoryService.class);

        Call<CategoryResponse> searchHero = categoryService.getCategories();

        searchHero.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<CategoryResponse> call, @NonNull Response<CategoryResponse> response) {
                if (response.isSuccessful()){
                    CategoryResponse categoryResponse = response.body();
                    if (categoryResponse != null) {
                        ArrayList<Category> categories = categoryResponse.getCategories();
                        showCategoryInterface.showCategories(categories);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<CategoryResponse> call, @NonNull Throwable t) {
                Log.d("HeroRepository", t.toString());
            }
        });
    }

    public interface ShowCategoryInterface{
        void showCategories(ArrayList<Category> categories);
    }
}
