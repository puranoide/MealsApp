package com.example.mealsapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.Objects;

public class CategoryPrototype extends RecyclerView.ViewHolder {
    private ImageView ivCategoryImage;
    private TextView tvCategoryName;
    private CardView cvCategories;
    private static final String KEY_NAME="name";

    private void initViews(){
    ivCategoryImage=itemView.findViewById(R.id.ivCategory);
    tvCategoryName=itemView.findViewById(R.id.tvNombreCategory);
    cvCategories=itemView.findViewById(R.id.CardviewCategory);

    }

    private void initViewsListeners(){
        cvCategories.setOnClickListener(view->{
            String name= Objects.requireNonNull(tvCategoryName.getText().toString());
            Context context = itemView.getContext();
            Intent intent = new Intent(context, categoryfiltermain.class); //
            intent.putExtra(KEY_NAME,name);
            context.startActivity(intent);
        });
    }
    public CategoryPrototype(@NonNull View itemView) {

        super(itemView);
        initViews();
        initViewsListeners();

    }


    public void bindTo(Category category) {
        tvCategoryName.setText(category.getStrCategory());
        Glide.with(itemView.getContext()).load(category.getStrCategoryThumb()).into(ivCategoryImage);
    }
}
