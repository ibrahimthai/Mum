package com.example.mum.RecipeHelper;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.CardViewIngredients.ItemClickListener;
import com.example.mum.R;

public class RecipeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageView;
    TextView textTitle, textDescription;
    ItemClickListener itemClickListener;

    RecipeHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageRecycler);
        this.textTitle = itemView.findViewById(R.id.recipeTitle);
        this.textDescription = itemView.findViewById(R.id.recipeDescription);

        itemView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }





}



