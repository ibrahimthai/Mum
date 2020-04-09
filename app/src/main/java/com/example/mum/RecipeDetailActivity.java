package com.example.mum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mum.DBHelper.DBFavoritesHelper;
import com.example.mum.DBHelper.DBRecipeHelper;

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
    private String recipeDrawable;

    ImageButton favoriteButton;

    DBRecipeHelper myFavoritesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        Context context = getApplicationContext();
        myFavoritesDB = new DBRecipeHelper(context);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        init();
        getData();

        System.out.println(recipeTitle);
        System.out.println(recipeCalories);
        System.out.println(recipeCompletionTime);
        System.out.println(recipeIngredients);
        System.out.println(recipeInstructions);
        System.out.println(recipeDrawable);

        int drawableId = getResources().getIdentifier(recipeDrawable, "drawable", getPackageName());

        mImageView.setImageResource(drawableId);
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
        recipeDrawable = b.getString("DRAWABLE");
    }

    // Initializes all buttons, texts, and image view
    private void init(){
        title = findViewById(R.id.recipeTitle);
        calories = findViewById(R.id.recipeCalories);
        completionTime = findViewById(R.id.recipeCompletionTime);
        ingredients = findViewById(R.id.recipeIngredients);
        instructions = findViewById(R.id.recipeInstructions);
        mImageView = findViewById(R.id.foodImage);

        favoriteButton = findViewById(R.id.imageButton);

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                myFavoritesDB.addRecipe( recipeTitle, recipeCalories, recipeCompletionTime, recipeIngredients, recipeInstructions,recipeDrawable);

            }
        });

    }

}
