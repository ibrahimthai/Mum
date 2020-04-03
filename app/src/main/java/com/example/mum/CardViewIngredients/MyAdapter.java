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

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context;
    private ArrayList<Model> models;

    public MyAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
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
                Intent intent = new Intent(context, IngredientsListActivity.class);

                // Fruits
                if (models.get(position).getTitle().equals("Fruits")) {
                    ingredientType = "Fruits.txt";
                    intent.putExtra("ingredientType", ingredientType);
                    context.startActivity(intent);
                }

                // Vegetables
                if (models.get(position).getTitle().equals("Vegetables")) {
                    ingredientType = "Vegetables.txt";
                    intent.putExtra("ingredientType", ingredientType);
                    context.startActivity(intent);
                }

                // Dairy
                if (models.get(position).getTitle().equals("Dairy")) {
                    ingredientType = "Dairy.txt";
                    intent.putExtra("ingredientType", ingredientType);
                    context.startActivity(intent);
                }

                // Bakery
                if (models.get(position).getTitle().equals("Bakery")) {
                    //ingredientType = models.get(position).getTitle();
                    ingredientType = "Bakery.txt";
                    intent.putExtra("ingredientType", ingredientType);
                    context.startActivity(intent);
                }

                // Meat and Poultry
                if (models.get(position).getTitle().equals("Meat and Poultry")) {
                    //ingredientType = models.get(position).getTitle();
                    ingredientType = "Meats and Poultry.txt";
                    intent.putExtra("ingredientType", ingredientType);
                    context.startActivity(intent);
                }

                // Fish and Seafood
                if (models.get(position).getTitle().equals("Fish and Seafood")) {
                    //ingredientType = models.get(position).getTitle();
                    ingredientType = "Fish and Seafood.txt";
                    intent.putExtra("ingredientType", ingredientType);
                    context.startActivity(intent);
                }

                // Grains, Beans, and Nuts
                if (models.get(position).getTitle().equals("Grains, Beans, and Nuts")) {
                    //ingredientType = models.get(position).getTitle();
                    ingredientType = "Grains&Beans.txt";
                    intent.putExtra("ingredientType", ingredientType);
                    context.startActivity(intent);
                }

            }
        });




    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
