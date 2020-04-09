package com.example.mum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeDetailActivity extends AppCompatActivity {

    private ImageView mImageView;

    public TextView title;
    public TextView calories;
    public TextView completionTime;
    public TextView ingredients;
    public TextView instructions;

    private String recipeTitle;
    private String recipeCalories;
    private String recipeCompletionTime;
    private String recipeIngredients;
    private String recipeInstructions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        init();
        getData();

        if (recipeTitle.equals("Scrambled Eggs"))
            mImageView.setImageResource(R.drawable.scrambled_eggs);
        else if (recipeTitle.equals("Fried Bacon"))
            mImageView.setImageResource(R.drawable.fried_bacon);
        else if (recipeTitle.equals("Sheepherders"))
            mImageView.setImageResource(R.drawable.sheepherders_breakfast);

        System.out.println(recipeTitle);
        System.out.println(recipeCalories);
        System.out.println(recipeCompletionTime);
        System.out.println(recipeIngredients);
        System.out.println(recipeInstructions);

        title.setText(recipeTitle);
        calories.setText(recipeCalories);
        completionTime.setText(recipeCompletionTime);
        ingredients.setText(recipeIngredients);
        instructions.setText(recipeInstructions);

    }

    // Get all data for the recipe
    private void getData() {

        // Get all data about the recipe based on what the user clicks on
        Bundle b = getIntent().getExtras();
        recipeTitle = b.getString("TITLE");
        recipeCalories = b.getString("CALORIES");
        recipeCompletionTime = b.getString("COMPLETIONTIME");
        recipeIngredients = b.getString("INGREDIENTS");
        recipeInstructions = b.getString("INSTRUCTIONS");
    }

    // Initializes all buttons, texts, and image view
    private void init(){
        title = findViewById(R.id.recipeTitle);
        calories = findViewById(R.id.recipeCalories);
        completionTime = findViewById(R.id.recipeCompletionTime);
        ingredients = findViewById(R.id.recipeIngredients);
        instructions = findViewById(R.id.recipeInstructions);
        mImageView = findViewById(R.id.foodImage);
    }



}
