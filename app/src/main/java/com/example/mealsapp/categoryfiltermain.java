package com.example.mealsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class categoryfiltermain extends AppCompatActivity {


    private static final String KEY_NAME="name";

    private RecyclerView rvMealsfilter;
    private MealAdapter adapter;

    private MealRepository mealRepository;

    private ArrayList<CategoryFilters> meals=new ArrayList<>();

    private void setupRecyclerView() {
        adapter = new MealAdapter(meals);
        rvMealsfilter.setAdapter(adapter);
        rvMealsfilter.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initViews(){
        rvMealsfilter=findViewById(R.id.rvCategoriesFilter);


    }
    private void setupRepository() {
        mealRepository = new MealRepository();
        mealRepository.setShowMealsInterface(meals -> {
            categoryfiltermain.this.meals = meals;
            adapter.setMeals(meals);
            adapter.notifyDataSetChanged();
        });
    }

    private void loadMeals(String name) {
        //String texto = getIntent().getStringExtra(KEY_NAME);
        mealRepository.searchMeals(name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryfiltermain);


        //
        //tvprueba.setText(texto);
        initViews();
        setupRecyclerView();
        setupRepository();

        // Obtener el intent
        Intent intent = getIntent();
        if (intent != null) {
            // Obtener el nombre del intent
            String name = intent.getStringExtra(KEY_NAME);
            if (name != null) {

                loadMeals(name);

            }
        }


    }
}