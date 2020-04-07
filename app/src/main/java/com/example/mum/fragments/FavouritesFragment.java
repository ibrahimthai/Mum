package com.example.mum.fragments;

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
import com.example.mum.R;

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
    private MyAdapter adapter;
    private List favoriteList;
    private File path;
    private View view;
    private String searchInput;
    private ArrayList<Model> models;
//Favorite list will contain all the numbers, this will query the db, then display to recycler view.

    @Override
    public void onCreate(Bundle savedInstanceState) {
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

        adapter = new MyAdapter(this.getContext(), getMyList());
        recyclerView.setAdapter(adapter);

         return view;

    }

    public static FavouritesFragment newInstance() {
        FavouritesFragment fragment = new FavouritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private void writeFavorites(String newFavId, File file)
    {

        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.i("ERROR WRITE", "Unable to open write stream;");
        }

        try {
            stream.write(newFavId.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("ERROR WRITE", "Unable to write stream;");
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("ERROR WRITE", "Unable to close write stream;");
        }

    }

    private ArrayList<Model> getMyList() {

        models = new ArrayList<>();

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

