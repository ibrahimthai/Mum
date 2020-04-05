package com.example.mum.RecipeHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.CardViewIngredients.IngredientsListActivity;
import com.example.mum.CardViewIngredients.ItemClickListener;
import com.example.mum.CardViewIngredients.Model;
import com.example.mum.CardViewIngredients.MyHolder;
import com.example.mum.R;
import com.example.mum.RecipeDetailActivity;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder> {

    private Context context;
    private ArrayList<Model> models;
    private String activityType;

    public RecipeAdapter(Context context, ArrayList<Model> models, String activityType) {
        this.context = context;
        this.models = models;
        this.activityType = activityType;

    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recipe, null);
        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeHolder recipeHolder, int i) {

        recipeHolder.textTitle.setText(models.get(i).getTitle());
        recipeHolder.textDescription.setText(models.get(i).getDescription());
        recipeHolder.imageView.setImageResource(models.get(i).getImage());

        // When user clicks on the an ingredient type
        recipeHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String ingredientType;
                Intent ingredientListIntent = new Intent(context, IngredientsListActivity.class);
                Intent recipeDetailIntent = new Intent(context, RecipeDetailActivity.class);



                /* RECIPES LIST */
                // Scrambled Eggs
                if (models.get(position).getTitle().equals("Scrambled Eggs")) {
                    context.startActivity(recipeDetailIntent);
                }

                // Fried Bacon
                if (models.get(position).getTitle().equals("Fried Bacon")) {
                    context.startActivity(recipeDetailIntent);
                }





            }
        });




    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
