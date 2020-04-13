package com.example.mum.RecipeHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.CardViewIngredients.IngredientsListActivity;
import com.example.mum.CardViewIngredients.ItemClickListener;
import com.example.mum.CardViewIngredients.Model;
import com.example.mum.CardViewIngredients.MyHolder;
import com.example.mum.DBHelper.DBRecipeHelper;
import com.example.mum.R;
import com.example.mum.RecipeDetailActivity;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeHolder> {

    private Context context;
    private ArrayList<Model> models;
    private String activityType;

    DBRecipeHelper dbRecipeHelper;

    public RecipeAdapter(Context context, ArrayList<Model> models, String activityType) {
        this.context = context;
        this.models = models;
        this.activityType = activityType;

    }

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_recipe, null);
        dbRecipeHelper = new DBRecipeHelper(viewGroup.getContext());
        System.out.println("Database command");
        return new RecipeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeHolder recipeHolder, int i) {

        //Cursor cursor = dbRecipeHelper.getRecipeContents();
        System.out.println("Number items: " + i);

        //dbRecipeHelper = new DBRecipeHelper(this.context);

        recipeHolder.textTitle.setText(models.get(i).getTitle());
        recipeHolder.textDescription.setText(models.get(i).getDescription());
        recipeHolder.imageView.setImageResource(models.get(i).getImage());

        // When user clicks on the an ingredient type
        recipeHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String ingredientType;

                Intent recipeDetailIntent = new Intent(context, RecipeDetailActivity.class);

                /* RECIPES LIST */
                // Scrambled Eggs
                if (models.get(position).getTitle().equals("Scrambled Eggs")) {

                    Cursor cursor = dbRecipeHelper.getRecipeContents("Scrambled Eggs");

                    if (cursor.moveToFirst()) {
                        recipeDetailIntent.putExtra("TITLE", cursor.getString(1));
                        recipeDetailIntent.putExtra("CALORIES", cursor.getString(2));
                        recipeDetailIntent.putExtra("COMPLETIONTIME", cursor.getString(3));
                        recipeDetailIntent.putExtra("INGREDIENTS", cursor.getString(4));
                        recipeDetailIntent.putExtra("INSTRUCTIONS", cursor.getString(5));
                        //System.out.println(cursor.getString(1));
                    }

                    cursor.close();

                    context.startActivity(recipeDetailIntent);

                }

                // Fried Bacon
                if (models.get(position).getTitle().equals("Fried Bacon")) {

                    Cursor cursor = dbRecipeHelper.getRecipeContents("Fried Bacon");

                    if (cursor.moveToFirst()) {
                        recipeDetailIntent.putExtra("TITLE", cursor.getString(1));
                        recipeDetailIntent.putExtra("CALORIES", cursor.getString(2));
                        recipeDetailIntent.putExtra("COMPLETIONTIME", cursor.getString(3));
                        recipeDetailIntent.putExtra("INGREDIENTS", cursor.getString(4));
                        recipeDetailIntent.putExtra("INSTRUCTIONS", cursor.getString(5));
                        //System.out.println(cursor.getString(1));
                    }

                    cursor.close();

                    context.startActivity(recipeDetailIntent);
                }

                // Sheepherder's
                if (models.get(position).getTitle().equals("Sheepherders")) {

                    System.out.println("I'm in Shepards");

                    Cursor cursor = dbRecipeHelper.getRecipeContents("Sheepherders");

                    if (cursor.moveToFirst()) {
                        recipeDetailIntent.putExtra("TITLE", cursor.getString(1));
                        recipeDetailIntent.putExtra("CALORIES", cursor.getString(2));
                        recipeDetailIntent.putExtra("COMPLETIONTIME", cursor.getString(3));
                        recipeDetailIntent.putExtra("INGREDIENTS", cursor.getString(4));
                        recipeDetailIntent.putExtra("INSTRUCTIONS", cursor.getString(5));
                        //System.out.println(cursor.getString(1));
                    }

                    cursor.close();

                    context.startActivity(recipeDetailIntent);
                }





            }
        });




    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void filterList(ArrayList<Model> filteredList){
        models = filteredList;
        notifyDataSetChanged();;
    }

}
