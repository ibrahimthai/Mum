package com.example.mum.CardViewIngredients;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context context;
    ArrayList<Model> models;

    public MyAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {

        myHolder.textTitle.setText(models.get(i).getTitle());
        myHolder.textDescription.setText(models.get(i).getDescription());
        myHolder.imageView.setImageResource(models.get(i).getImage());


        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                if (models.get(position).getTitle().equals("Fruits")) {
                    System.out.println("You clicked: " + models.get(position).getTitle());
                }

                if (models.get(position).getTitle().equals("Vegetables")) {
                    System.out.println("You clicked: " + models.get(position).getTitle());
                }

                if (models.get(position).getTitle().equals("Dairy")) {
                    System.out.println("You clicked: " + models.get(position).getTitle());
                }

                if (models.get(position).getTitle().equals("Meat and Poultry")) {
                    System.out.println("You clicked: " + models.get(position).getTitle());
                }

            }
        });




    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
