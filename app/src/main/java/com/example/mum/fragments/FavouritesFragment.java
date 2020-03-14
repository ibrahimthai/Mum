package com.example.mum.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.mum.R;

public class FavouritesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Favourites");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false);
    }

    public static FavouritesFragment newInstance() {
        FavouritesFragment fragment = new FavouritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}
