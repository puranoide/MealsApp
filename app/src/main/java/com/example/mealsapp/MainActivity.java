package com.example.mealsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;

    private CategoryRepository categoryRepository;

    private ArrayList<Category> categories=new ArrayList<>();

    private void initViews(){
        recyclerView=findViewById(R.id.rvCategories);
    }

    private void setupRecyclerView() {
        adapter = new CategoryAdapter(categories);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void setupRepository() {
        categoryRepository = new CategoryRepository();
        categoryRepository.setShowCategoryInterface(categories -> {
            MainActivity.this.categories = categories;
            adapter.setCategories(categories);
            adapter.notifyDataSetChanged();
        });
    }
    private void loadCategories() {
        categoryRepository.getCategories();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupRecyclerView();
        setupRepository();
        loadCategories();
    }
}