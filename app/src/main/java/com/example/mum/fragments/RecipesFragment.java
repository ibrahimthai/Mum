package com.example.mum.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.CardViewIngredients.Model;
import com.example.mum.DBHelper.DBRecipeHelper;
import com.example.mum.R;
import com.example.mum.RecipeHelper.RecipeAdapter;

import java.util.ArrayList;

public class RecipesFragment extends Fragment {

  RecyclerView recyclerView;
  RecipeAdapter adapter;

  DBRecipeHelper dbRecipeHelper;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle("Recipes");







  }

  // Icons, Title, and Description
  private ArrayList<Model> getMyList() {

    ArrayList<Model> models = new ArrayList<>();

    Model m = new Model();
    m.setTitle("Scrambled Eggs");
    m.setDescription("100 Calories");
    m.setImage(R.drawable.scrambled_eggs);
    models.add(m);

    m = new Model();
    m.setTitle("Fried Bacon");
    m.setDescription("300 Calories");
    m.setImage(R.drawable.fried_bacon);
    models.add(m);

    m = new Model();
    m.setTitle("Sheepherders");
    m.setDescription("800 Calories");
    m.setImage(R.drawable.sheepherders_breakfast);
    models.add(m);

    return models;

  }




  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_recipes, container, false);

    recyclerView = view.findViewById(R.id.recipesRecyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

    adapter = new RecipeAdapter(this.getContext(), getMyList(), "RecipeDetailActivity.class");
    recyclerView.setAdapter(adapter);

    // Initiate a database helper to call SQL commands
    dbRecipeHelper = new DBRecipeHelper(this.getContext());
    Cursor cursor = dbRecipeHelper.getListContents();
    System.out.println("Num of Recipes: " + cursor.getCount());

    // If recipe database is empty
    if (cursor.getCount() == 0) {
      AddData();
    }
    else {
      System.out.println("Recipes already there");
    }

    // Inflate the layout for this fragment
    return view;
  }

  public static RecipesFragment newInstance() {
    RecipesFragment fragment = new RecipesFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }


  /* ADD ANY EXTRA RECIPES HERE */
  // Adds Recipes to the SQL database
  public void AddData() {

    boolean insertData1;
    boolean insertData2;
    boolean insertData3;

    insertData1 = dbRecipeHelper.addRecipe(
            "Scrambled Eggs",
            "100 Calories",
            "5 Minutes",
            "- Eggs\n",
            "1. Mix eggs\n2. Fry in pan\n");

    insertData2 = dbRecipeHelper.addRecipe(
            "Fried Bacon",
            "300 Calories",
            "1 Hour",
            "- Bacon\n",
            "1. Fry bacon\n");

    insertData3 = dbRecipeHelper.addRecipe(
            "Sheepherders",
            "800 Calories",
            "30 Minutes",
            "- 3/4 pound bacon strips, finely chopped\n" +
                      "- 1 medium onion, chopped\n" +
                      "- 1 package (30 ounces) frozen shredded hash brown potatoes, thawed\n" +
                      "- 8 large eggs\n" +
                      "- 1/2 teaspoon salt\n" +
                      "- 1/4 teaspoon pepper\n" +
                      "- 1 cup Kerrygold shredded cheddar cheese\n",
            "1. In a large skillet, cook bacon and onion over medium heat until bacon is crisp. Drain, reserving 1/4 cup drippings in pan.\n\n" +
                      "2. Stir in hash browns. Cook, uncovered, over medium heat until bottom is golden brown, about 10 minutes. Turn potatoes. With the back of a spoon, make 8 evenly spaced wells in potato mixture. Break 1 egg into each well. Sprinkle with salt and pepper.\n\n" +
                      "3. Cook, covered, on low until eggs are set and potatoes are tender, about 10 minutes. Sprinkle with cheese; let stand until cheese is melted.\n");




    if(insertData1==true && insertData2==true && insertData3==true){
      System.out.println("Recipe added");
    }else{
      System.out.println("Something went wrong");
    }
  }




}
