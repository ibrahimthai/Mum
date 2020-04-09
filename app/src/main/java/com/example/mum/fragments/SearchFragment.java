package com.example.mum.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mum.CardViewIngredients.Model;
import com.example.mum.R;
import com.example.mum.RecipeHelper.RecipeAdapter;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecipeAdapter adapter;
    private View view;
    private String searchInput;
    private ArrayList<Model> models;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Search");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_search, container, false);

        final EditText searchField = (EditText)view.findViewById(R.id.editText);

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

    private ArrayList<Model> getMyList() {

        models = new ArrayList<>();

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

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
