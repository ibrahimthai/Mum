package com.example.mum.CardViewIngredients;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.R;
import com.example.mum.RecipeDetailActivity;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context;
    private ArrayList<Model> models;
    private String activityType;

    public MyAdapter(Context context, ArrayList<Model> models, String activityType) {
        this.context = context;
        this.models = models;
        this.activityType = activityType;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        @SuppressLint("InflateParams") View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {

        myHolder.textTitle.setText(models.get(i).getTitle());
        myHolder.textDescription.setText(models.get(i).getDescription());
        myHolder.imageView.setImageResource(models.get(i).getImage());

        // When user clicks on the an ingredient type
        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String ingredientType;
                Intent ingredientListIntent = new Intent(context, IngredientsListActivity.class);
                Intent recipeDetailIntent = new Intent(context, RecipeDetailActivity.class);

                // Fruits
                if (models.get(position).getTitle().equals("Fruits")) {
                    ingredientType = "Fruits.txt";
                    ingredientListIntent.putExtra("ingredientType", ingredientType);
                    context.startActivity(ingredientListIntent);
                }

                // Vegetables
                if (models.get(position).getTitle().equals("Vegetables")) {
                    ingredientType = "Vegetables.txt";
                    ingredientListIntent.putExtra("ingredientType", ingredientType);
                    context.startActivity(ingredientListIntent);
                }

                // Dairy
                if (models.get(position).getTitle().equals("Dairy")) {
                    ingredientType = "Dairy.txt";
                    ingredientListIntent.putExtra("ingredientType", ingredientType);
                    context.startActivity(ingredientListIntent);
                }

                // Bakery
                if (models.get(position).getTitle().equals("Bakery")) {
                    ingredientType = "Bakery.txt";
                    ingredientListIntent.putExtra("ingredientType", ingredientType);
                    context.startActivity(ingredientListIntent);
                }

                // Meat and Poultry
                if (models.get(position).getTitle().equals("Meat and Poultry")) {
                    ingredientType = "Meats and Poultry.txt";
                    ingredientListIntent.putExtra("ingredientType", ingredientType);
                    context.startActivity(ingredientListIntent);
                }

                // Fish and Seafood
                if (models.get(position).getTitle().equals("Fish and Seafood")) {
                    ingredientType = "Fish and Seafood.txt";
                    ingredientListIntent.putExtra("ingredientType", ingredientType);
                    context.startActivity(ingredientListIntent);
                }

                // Grains, Beans, and Nuts
                if (models.get(position).getTitle().equals("Grains, Beans, and Nuts")) {
                    ingredientType = "Grains&Beans.txt";
                    ingredientListIntent.putExtra("ingredientType", ingredientType);
                    context.startActivity(ingredientListIntent);
                }





            }
        });




    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void filterList(ArrayList<Model> filteredList)
    {

        models = filteredList;
        notifyDataSetChanged();

    }
}
