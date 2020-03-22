package com.example.mum.CardViewIngredients;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mum.MainActivity;
import com.example.mum.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class IngredientsListActivity extends AppCompatActivity {

    String myFile;
    ArrayList<String> ingredientsList = new ArrayList<>();
    ListView listView;
    String data[];

    String[] ListViewItems = new String[] {
            "Tomato",
            "Broccoli",
            "Apple",
            "Orange",
            "Papaya",
            "Onions",
            "Cilantro",
            "Green Onions",
            "Potato",
            "Ginger"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items_list);

        Intent intent = getIntent();
        myFile = intent.getStringExtra("ingredientType");

        listView = findViewById(R.id.ingredientsList);

        readData();
        System.out.println(myFile);

        ArrayAdapter<String> autocompleteAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice, ingredientsList);
        listView.setAdapter(autocompleteAdapter);





    }


    public void readData() {

        InputStream inputStream;
        BufferedReader bufferedReader;

        try {
            inputStream = this.getResources().getAssets().open(myFile);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            for (String line; (line = bufferedReader.readLine()) != null;) {
                //System.out.println(line);
                ingredientsList.add(line);
            }

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Can't open file");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_add_ingredients, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.addAllIngredientsButton) {
            Toast.makeText(getApplicationContext(), "Ingredients Added", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(IngredientsListActivity.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
