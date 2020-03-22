package com.example.mum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mum.CardViewIngredients.IngredientsCardViewActivity;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autocomplete;

    ListView listview;
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

    SparseBooleanArray sparseBooleanArray ;

    Button btnDeleteItems;
    ArrayList<String> mySelectedList = new ArrayList<>();
    int addIngredientFlag = 0;
    CheckBox selectAll;
    FloatingActionButton searchBreakfastBtn;

    ArrayList<String> mySelectedListFromIngredientsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autocomplete = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> autocompleteAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, ListViewItems);
        autocomplete.setThreshold(0);
        autocomplete.setAdapter(autocompleteAdapter);
        autocomplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                // here is your selected item
                System.out.println("You chose: " + selectedItem);

                // If list is empty, add an item without going through duplicate check
                if (mySelectedList.isEmpty()) {
                    mySelectedList.add(selectedItem);
                    autocomplete.setText("");
                }
                // If something is in the list, check for duplicates before add
                else if (mySelectedList.size() >= 1) {

                    for (int i = 0; i < mySelectedList.size(); i++) {
                        if (mySelectedList.get(i).equals(selectedItem)) {
                            Toast.makeText(getApplicationContext(), "Item already added", Toast.LENGTH_SHORT).show();
                            autocomplete.setText("");
                            addIngredientFlag = 0;
                        }
                        else {
                            addIngredientFlag = 1;
                        }
                    }

                    // If the selected item doesn't exist
                    if (addIngredientFlag == 1) {
                        // Add ingredient to the list
                        mySelectedList.add(selectedItem);
                        autocomplete.setText("");
                        addIngredientFlag = 0;
                        Toast.makeText(getApplicationContext(), "Added " + selectedItem, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        selectAll = findViewById(R.id.selectAll);
        selectAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (mySelectedList.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nothing to select all", Toast.LENGTH_SHORT).show();
                    selectAll.setChecked(false);
                    return;
                }

                if (selectAll.isChecked()){
                    for ( int i=0; i < listview.getChildCount(); i++) {
                        listview.setItemChecked(i, true);
                    }
                }
                else {
                    for ( int i=0; i < listview.getChildCount(); i++) {
                        listview.setItemChecked(i, false);
                    }
                }

            }
        });


        // Delete Button
        btnDeleteItems = findViewById(R.id.deleteButton);
        btnDeleteItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mySelectedList.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Nothing to delete", Toast.LENGTH_SHORT).show();
                }
                else if (mySelectedList.size() >= 1) {
                    Toast.makeText(getApplicationContext(), "List selected items " + mySelectedList.size(), Toast.LENGTH_SHORT).show();
                    mySelectedList.clear();


                }
            }
        });


        // Main Menu -> Search Breakfast Menu
        searchBreakfastBtn = findViewById(R.id.searchBreakfast);
        searchBreakfastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecipeListActivity.class));
            }
        });




        listview = findViewById(R.id.produceList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (MainActivity.this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, mySelectedList );

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sparseBooleanArray = listview.getCheckedItemPositions();

                String ValueHolder = "" ;

                int i = 0 ;

                while (i < sparseBooleanArray.size()) {

                    if (sparseBooleanArray.valueAt(i)) {

                        //ValueHolder += ListViewItems [ sparseBooleanArray.keyAt(i) ] + ",";
                        Toast.makeText(MainActivity.this, "ListView Selected Values = " + sparseBooleanArray.keyAt(i), Toast.LENGTH_LONG).show();

                    }

                    i++ ;
                }

            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.addIngredientButton) {
            Toast.makeText(getApplicationContext(), "Add an Ingredient", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, IngredientsCardViewActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }




}
