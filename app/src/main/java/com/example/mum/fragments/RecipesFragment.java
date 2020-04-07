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

import java.util.ArrayList;

public class RecipesFragment extends Fragment {

  RecyclerView recyclerView;
  MyAdapter adapter;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle("Recipes");



  }


  private ArrayList<Model> getMyList() {

    ArrayList<Model> models = new ArrayList<>();

    Model m = new Model();
    m.setTitle("Fruits");
    m.setDescription("e.g. Apples, Oranges, Peaches");
    m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
    models.add(m);

    m = new Model();
    m.setTitle("Vegetables");
    m.setDescription("e.g. Tomatoes, Onions, Potatoes");
    m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
    models.add(m);

    m = new Model();
    m.setTitle("Dairy");
    m.setDescription("e,g, Milk, Cheese, Yogurt");
    m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
    models.add(m);

    m = new Model();
    m.setTitle("Bakery");
    m.setDescription("e.g. Bread, Baguette, Bagel");
    m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
    models.add(m);

    m = new Model();
    m.setTitle("Meat and Poultry");
    m.setDescription("e.g. Beef, Chicken, Pork");
    m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
    models.add(m);

    m = new Model();
    m.setTitle("Fish and Seafood");
    m.setDescription("e.g. Salmon, Tuna, Crab");
    m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
    models.add(m);

    m = new Model();
    m.setTitle("Grains, Beans, and Nuts");
    m.setDescription("e.g. Oat, Legumes, Cashews");
    m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
    models.add(m);

    return models;

  }




  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_recipes, container, false);

    recyclerView = view.findViewById(R.id.recipesRecyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

    adapter = new MyAdapter(this.getContext(), getMyList());
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
