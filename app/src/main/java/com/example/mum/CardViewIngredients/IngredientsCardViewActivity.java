package com.example.mum.CardViewIngredients;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mum.R;

import java.util.ArrayList;

public class IngredientsCardViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;

    TextView mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients_card_view);

        //mytext = findViewById(R.id.textView);
        //mytext.setText("Changed");

        recyclerView = findViewById(R.id.ingredientsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(this, getMyList());
        recyclerView.setAdapter(adapter);

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
        m.setTitle("Grains, Beans and Nuts");
        m.setDescription("e.g. Oat, Legumes, Cashews");
        m.setImage(R.mipmap.ic_launcher_produce_icon_foreground);
        models.add(m);


        return models;

    }





}
