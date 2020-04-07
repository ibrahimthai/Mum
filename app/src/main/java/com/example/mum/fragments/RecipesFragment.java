package com.example.mum.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.CardViewIngredients.Model;
import com.example.mum.CardViewIngredients.MyAdapter;
import com.example.mum.R;
import com.example.mum.RecipeHelper.RecipeAdapter;

import java.util.ArrayList;

public class RecipesFragment extends Fragment {

  RecyclerView recyclerView;
  RecipeAdapter adapter;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle("Recipes");



  }


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

    return models;

  }




  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_recipes, container, false);

    recyclerView = view.findViewById(R.id.recipesRecyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

    adapter = new RecipeAdapter(this.getContext(), getMyList(), "RecipeDetailActivity.class");
    recyclerView.setAdapter(adapter);
    // Inflate the layout for this fragment
    return view;
  }

  public static RecipesFragment newInstance() {
    RecipesFragment fragment = new RecipesFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }
}
