package com.example.mum.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.CardViewIngredients.Model;
import com.example.mum.CardViewIngredients.MyAdapter;
import com.example.mum.DBHelper.DBFavoritesHelper;
import com.example.mum.DBHelper.DBRecipeHelper;
import com.example.mum.R;
import com.example.mum.RecipeHelper.RecipeAdapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FavouritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    // this to the recipe type.
    private RecipeAdapter adapter;
    private List favoriteList;
    private File path;
    private View view;
    private String searchInput;
    private ArrayList<Model> models;
    private DBRecipeHelper favoriteDB;
//Favorite list will contain all the numbers, this will query the db, then display to recycler view.

    @Override
    public void onCreate(Bundle savedInstanceState) {

        favoriteDB = new DBRecipeHelper(this.getContext());

        super.onCreate(savedInstanceState);
        getActivity().setTitle("Favourites");
        setContentView(R.layout.fragment_favourites);

        try {

            path = getContext().getExternalFilesDir(null);

        }
        catch(Exception e)
        {
            path = getContext().getFilesDir();
        }

        if(path == null)
        {

            path = getContext().getFilesDir();

        }

        if(path == null)
        {

            Log.i("ERROR FAVORITE", "Unable to get path");

        }

        File favoriteFile = new File(path,"MUMFavorites.txt");
        try {
            favoriteFile.createNewFile(); // if file already exists will do nothing
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private void setContentView(int fragment_favourites) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourites, container, false);

        final EditText searchField = (EditText)view.findViewById(R.id.favoriteSearchTextView);

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

                searchInput = searchField.getText().toString();
                displaySearch();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }
        });

        recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new RecipeAdapter(this.getContext(), getMyList(),"FavouritesFragment.class");
        recyclerView.setAdapter(adapter);

         return view;

    }

    public static FavouritesFragment newInstance() {
        FavouritesFragment fragment = new FavouritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private ArrayList<Model> getMyList() {

        models = new ArrayList<>();

        Cursor cursor = favoriteDB.getListContents();
        System.out.println("Num of Recipes: " + cursor.getCount());

        if(cursor != null)
        {

            try {
                do
                {

                    Model m = new Model();
                    Log.d("FAVES", "1 ");
                    m.setTitle(cursor.getString( cursor.getColumnIndex("title") ));
                    Log.d("FAVES", "2");
                    m.setDescription(cursor.getString( cursor.getColumnIndex("COLUMN_CALORIES"))+ " Calroies" );
                    Log.d("FAVES", "3 ");
                    int drawableId = getResources().getIdentifier(cursor.getString( cursor.getColumnIndex("COLUMN_DRAWABLE") ), "drawable", getContext().getPackageName());
                    Log.d("FAVES", "4  ");
                    m.setImage(drawableId);
                    models.add(m);

                }while (cursor.moveToNext());
            } catch (Exception e) {
                Log.d("FAVES", "Error while making list ");
            }

        }

        return models;

    }

    private void displaySearch()
    {

        ArrayList<Model> filteredList = new ArrayList<>();

        for (Model item : models)
        {

            if (item.getTitle().toLowerCase().contains(searchInput.toLowerCase()))
            {

                 filteredList.add(item);

            }

        }

        adapter.filterList(filteredList);

    }

}

