package com.example.mum;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.mum.fragments.FavouritesFragment;
import com.example.mum.fragments.RecipesFragment;
import com.example.mum.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RecipeListActivity extends AppCompatActivity {

  BottomNavigationView bottomNavigation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.actvity_recipe_list);
    bottomNavigation = findViewById(R.id.bottom_navigation);
    bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    openFragment(RecipesFragment.newInstance());
  }

  public void openFragment(Fragment fragment) {
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.replace(R.id.container, fragment);
    transaction.addToBackStack(null);
    transaction.commit();
  }

  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
          new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()) {
                case R.id.navigation_favourites:
                  openFragment(FavouritesFragment.newInstance());
                  return true;
                case R.id.navigation_recipes:
                  openFragment(RecipesFragment.newInstance());
                  return true;
                case R.id.navigation_search:
                  openFragment(SearchFragment.newInstance());
                  return true;
              }
              return false;
            }
          };


}
